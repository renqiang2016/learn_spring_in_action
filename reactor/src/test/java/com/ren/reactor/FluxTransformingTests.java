package com.ren.reactor;

import lombok.Data;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 转换和过滤反应式流
 *
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/11 16:43
 */
public class FluxTransformingTests {

    @Test
    public void skipFlux() {
        Flux<String> skipFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .skip(3);
        StepVerifier.create(skipFlux)
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void skipAFewSeconds() {
        Flux<String> skipFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .delayElements(Duration.ofSeconds(1))
                .skip(Duration.ofSeconds(4));
        StepVerifier.create(skipFlux)
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void takeFlux() {
        Flux<String> takeFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .take(3);
        StepVerifier.create(takeFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .verifyComplete();
    }

    @Test
    public void takeAFewSeconds() {
        Flux<String> takeFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .delayElements(Duration.ofSeconds(1))
                .take(Duration.ofSeconds(3));
        StepVerifier.create(takeFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .verifyComplete();
    }

    @Test
    public void filterFlux() {
        Flux<String> filterFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .filter(n -> n.endsWith("e"));
        StepVerifier.create(filterFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .verifyComplete();
    }

    @Test
    public void distinctFlux() {
        Flux<String> distinctFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry",
                "Orange", "Grape", "Strawberry")
                .distinct();
        StepVerifier.create(distinctFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Data
    private static class Player {
        private final String firstName;
        private final String lastName;
    }

    @Test
    public void mapFlux() {
        Flux<Player> playerFlux = Flux.just("Yao Ming", "Michal Jordan")
                .map(n -> {
                    String[] split = n.split(" ");
                    return new Player(split[0], split[1]);
                });
        StepVerifier.create(playerFlux)
                .expectNext(new Player("Yao", "Ming"))
                .expectNext(new Player("Michal", "Jordan"))
                .verifyComplete();
    }

    @Test
    public void flatMap() {
        Flux<Player> playerFlux = Flux
                .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .flatMap(n -> Mono.just(n)
                        .map(p -> {
                            String[] split = p.split("\\s");
                            return new Player(split[0], split[1]);
                        })
                        .subscribeOn(Schedulers.parallel())
                );

        List<Player> playerList = Arrays.asList(
                new Player("Michael", "Jordan"),
                new Player("Scottie", "Pippen"),
                new Player("Steve", "Kerr"));

        StepVerifier.create(playerFlux)
                .expectNextMatches(playerList::contains)
                .expectNextMatches(playerList::contains)
                .expectNextMatches(playerList::contains)
                .verifyComplete();
    }

    @Test
    public void bufferFlux() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        Flux<List<String>> bufferedFlux = fruitFlux.buffer(3);
        StepVerifier.create(bufferedFlux)
                .expectNext(Arrays.asList("Apple", "Orange", "Grape"))
                .expectNext(Arrays.asList("Banana", "Strawberry"))
                .verifyComplete();
    }

    @Test
    public void bufferFlatMap() {
        Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .buffer(3)
                .flatMap(x->
                        Flux.fromIterable(x)
                            .map(String::toUpperCase)
                            .subscribeOn(Schedulers.parallel())
                            .log()
                ).subscribe();
    }

    @Test
    public void collectListFlux() {
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        Mono<List<String>> fruitListMono = fruitFlux.collectList();
        StepVerifier.create(fruitListMono)
                .expectNext(Arrays.asList("Apple", "Orange", "Grape", "Banana", "Strawberry"))
                .verifyComplete();
    }

    @Test
    public void collectMapFlux() {
        Flux<String> animalFlux = Flux.just(
                "aardvark", "elephant", "koala", "eagle", "kangaroo");

        Mono<Map<Character, String>> animalMapMono =
                animalFlux.collectMap(a -> a.charAt(0));

        StepVerifier.create(animalMapMono)
                .expectNextMatches(map -> map.size() == 3 &&
                        map.get('a').equals("aardvark") &&
                        map.get('e').equals("eagle") &&
                        map.get('k').equals("kangaroo"))
                .verifyComplete();
    }
}
