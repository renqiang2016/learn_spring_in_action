package com.ren.microservice_client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ren.microservice_client.common.NotFeignAndNotWebClientCondition;
import com.ren.microservice_client.model.Ingredient;
import com.ren.microservice_client.service.IngredientServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ingredients")
@Conditional(NotFeignAndNotWebClientCondition.class)
@Slf4j
public class IngredientController {

  private IngredientServiceClient client;

  @Autowired
  public IngredientController(IngredientServiceClient client) {
    this.client = client;
  }
  
  @GetMapping
  @HystrixCommand(fallbackMethod = "getDefaultIngredients")
  public String ingredientList(Model model) {
    log.info("Fetched all ingredients from a RestTemplate-based service.");
    model.addAttribute("ingredients", client.getAllIngredients());
    return "ingredientList";
  }

  private String getDefaultIngredients(Model model) {
    List<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
    ingredients.add(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
    ingredients.add(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
    model.addAttribute("ingredients", ingredients);
    return "ingredientList";
  }
  
  @GetMapping("/{id}")
  public String ingredientDetailPage(@PathVariable("id") String id, Model model) {
    log.info("Fetched an ingredient from a RestTemplate-based service.");
    model.addAttribute("ingredient", client.getIngredientById(id));
    return "ingredientDetail";
  }
  
}
