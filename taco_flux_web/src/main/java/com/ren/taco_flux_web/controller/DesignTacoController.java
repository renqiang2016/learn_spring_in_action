package com.ren.taco_flux_web.controller;

import com.ren.taco_flux_web.model.Taco;
import com.ren.taco_flux_web.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resources;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/9/1 19:26
 */
@Slf4j
@RestController
@RequestMapping(value = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    private TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/recent")
    public Flux<Taco> recentTacos() {
        return tacoRepository.findAll().take(12);
    }

    @GetMapping("/{id}")
    public Mono<Taco> tacoById(@PathVariable("id") Long id) {
        return tacoRepository.findById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> saveTaco(@RequestBody Mono<Taco> tacoMono) {
        return tacoRepository.saveAll(tacoMono).next();
    }
}
