package com.ren.learn_spring_in_action.dao.repository;

import com.ren.learn_spring_in_action.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/3 9:12
 */
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
