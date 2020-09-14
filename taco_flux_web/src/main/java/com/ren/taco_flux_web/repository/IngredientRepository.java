package com.ren.taco_flux_web.repository;

import com.ren.taco_flux_web.model.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/3 9:12
 */
@CrossOrigin(origins = "*")
public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {

}
