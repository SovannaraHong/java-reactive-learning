package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class monoToFlux {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello");
        Flux.from(mono).subscribe(System.out::println);//this convert to flux
    }
}
