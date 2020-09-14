package com.ren.taco_flux_web.repository;


import com.ren.taco_flux_web.model.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/7 16:07
 */
public interface TacoRepository extends ReactiveCrudRepository<Taco, String> {

    Flux<Taco> findByOrderByCreatedAtDesc();
}
