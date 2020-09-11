package com.ren.reactor;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

/**
 * 组合反应式类型
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/11 15:59
 */
public class FluxMergingTests {

    @Test
    public void mergeFluxes() {
        Flux<String> nameFlux = Flux.just("Tom", "Jon", "Linda")
                .delayElements(Duration.ofMillis(500));
        Flux<String> sexFlux = Flux.just("man", "woman", "woman")
                .delaySubscription(Duration.ofMillis(250))
                .delayElements(Duration.ofMillis(500));
        Flux<String> mergeFlux = nameFlux.mergeWith(sexFlux);
        StepVerifier.create(mergeFlux)
                .expectNext("Tom")
                .expectNext("man")
                .expectNext("Jon")
                .expectNext("woman")
                .expectNext("Linda")
                .expectNext("woman")
                .verifyComplete();
    }

    @Test
    public void zipFluxes() {
        Flux<String> nameFlux = Flux.just("Tom", "Jon", "Linda")
                .delayElements(Duration.ofMillis(500));
        Flux<String> sexFlux = Flux.just("man", "woman", "woman")
                .delaySubscription(Duration.ofMillis(250))
                .delayElements(Duration.ofMillis(500));
        Flux<Tuple2<String, String>> zipFlux = Flux.zip(nameFlux, sexFlux);
        StepVerifier.create(zipFlux)
                .expectNextMatches(p ->
                        p.getT1().equals("Tom") && p.getT2().equals("man"))
                .expectNextMatches(p ->
                        p.getT1().equals("Jon") && p.getT2().equals("woman"))
                .expectNextMatches(p ->
                        p.getT1().equals("Linda") && p.getT2().equals("woman"))
                .verifyComplete();
    }

    @Test
    public void zipFluxesToObject() {
        Flux<String> nameFlux = Flux.just("Tom", "Jon", "Linda")
                .delayElements(Duration.ofMillis(500));
        Flux<String> sexFlux = Flux.just("man", "woman", "woman")
                .delaySubscription(Duration.ofMillis(250))
                .delayElements(Duration.ofMillis(500));
        Flux<String> zipFlux = Flux.zip(nameFlux, sexFlux, (a, b) -> a + " is " + b);
        StepVerifier.create(zipFlux)
                .expectNext("Tom is man")
                .expectNext("Jon is woman")
                .expectNext("Linda is woman")
                .verifyComplete();
    }

    @Test
    public void firstFlux() {
        Flux<String> nameFlux = Flux.just("Tom", "Jon", "Linda")
                .delaySubscription(Duration.ofMillis(100));
        Flux<String> sexFlux = Flux.just("man", "woman", "woman");
        Flux<String> zipFlux = Flux.first(nameFlux, sexFlux);
        StepVerifier.create(zipFlux)
                .expectNext("man")
                .expectNext("woman")
                .expectNext("woman")
                .verifyComplete();
    }
}
