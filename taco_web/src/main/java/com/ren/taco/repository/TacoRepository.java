package com.ren.taco.repository;

import com.ren.taco.model.Taco;
import org.springframework.data.repository.CrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/7 16:07
 */
public interface TacoRepository extends CrudRepository<Taco, Long> {

}
