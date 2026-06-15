package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

import java.util.List;

public class fluxFromCollection {
    public static void main(String[] args) {

        //collection
        List<Integer> integers = List.of(1, 34, 5);
        Flux<Integer> integerFlux = Flux.fromIterable(integers);
        integerFlux.subscribe(System.out::println);

        //array
        Integer[] integerArray = {1, 2, 3, 4, 5};
        Flux<Integer> integerFlux1 = Flux.fromArray(integerArray);
        integerFlux1.subscribe(System.out::println);
    }
}
