package com.ren.taco.repository;

import com.ren.taco.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/3 9:12
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
