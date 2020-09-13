package com.ren.taco_flux_web.repository;

import com.ren.taco_flux_web.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.nio.channels.FileChannel;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/8 9:43
 */
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String username);

    //User findByUsername(String userName);
}
