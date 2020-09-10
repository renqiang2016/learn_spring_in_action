package com.ren.taco.repository;

import com.ren.taco.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 9:43
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String userName);
}
