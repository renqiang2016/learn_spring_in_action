package com.ren.taco_flux_web.controller;

import com.ren.taco_flux_web.model.Taco;
import com.ren.taco_flux_web.repository.TacoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static reactor.core.publisher.Mono.just;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/12 15:29
 */
@Configuration
public class HelloWorldController {

    @Autowired
    private TacoRepository tacoRepository;

    @Bean
    public RouterFunction<?> helloRouterFunction() {
        return route(GET("/hello"),
                request->ok().body(just("Hello World!"), String.class));
    }

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/design/taco"), this::recents)
                .andRoute(POST("/design"), this::postTaco);
    }

    @NotNull
    public Mono<ServerResponse> recents(ServerRequest request) {
        return ServerResponse.ok()
                .body(tacoRepository.findAll().take(12), Taco.class);
    }

    @NotNull
    public Mono<ServerResponse> postTaco(ServerRequest request) {
        /*Mono<Taco> taco = request.bodyToMono(Taco.class);
        Mono<Taco> savedTaco = tacoRepository.save(taco);
        return ServerResponse.created(URI.create("http://localhost:8888/design/taco/" +
                savedTaco.blockOptional().get().getId()))
                .body(savedTaco, Taco.class);*/
        return null;
    }
}
