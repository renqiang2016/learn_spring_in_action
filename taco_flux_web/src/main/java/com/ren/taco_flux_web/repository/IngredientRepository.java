package com.ren.taco_flux_web.repository;

import com.ren.taco_flux_web.model.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/3 9:12
 */
public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {

}
