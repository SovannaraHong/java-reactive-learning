package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

public class fluxToMono {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("Hello", "World");
        flux
                .next()//this convert to mono
                .subscribe(System.out::println);
    }
}
