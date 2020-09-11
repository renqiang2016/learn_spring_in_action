package com.ren.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * 逻辑操作
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/12 0:21
 */
public class FluxLogicTests {

    @Test
    public void allFlux() {
        Flux<String> fruitFlux = Flux.just("apple", "Orange", "Grape", "Banana", "Strawberry");
        Mono<Boolean> hasAMono = fruitFlux.all(a->a.contains("a"));
        StepVerifier.create(hasAMono)
                .expectNext(true)
                .verifyComplete();
        Mono<Boolean> hasXMono = fruitFlux.all(a->a.contains("x"));
        StepVerifier.create(hasXMono)
                .expectNext(false)
                .verifyComplete();
    }

    @Test
    public void anyFlux() {
        Flux<String> fruitFlux = Flux.just("apple", "Orange", "Grape", "Banana", "Strawberry");
        Mono<Boolean> hasLMono = fruitFlux.any(a->a.contains("l"));
        StepVerifier.create(hasLMono)
                .expectNext(true)
                .verifyComplete();
        Mono<Boolean> hasZMono = fruitFlux.any(a->a.contains("z"));
        StepVerifier.create(hasZMono)
                .expectNext(false)
                .verifyComplete();
    }
}
