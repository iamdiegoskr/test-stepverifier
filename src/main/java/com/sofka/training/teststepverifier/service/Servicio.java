package com.sofka.training.teststepverifier.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class Servicio {

    public Mono<String> buscarUno() {
        return Mono.just("Pedro");
    }

    public Flux<String> buscarTodos() {
        return Flux.just("Pedro", "Maria", "Juan", "Diego");
    }

    public Flux<String> buscarTodosLento() {
        return Flux.just("Pedro", "Maria", "Juan", "Diego").delaySequence(Duration.ofSeconds(2));
    }

    public Flux<String> buscarTodosFiltro() {
        return Flux.just("John", "Monica", "Mark", "Cloe", "Frank", "Casper", "Olivia", "Emily", "Cate")
                .filter(name -> name.length() == 4)
                .map(String::toUpperCase);
    }

}
