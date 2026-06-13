package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

public class flux1 {
    public static void main(String[] args) {

        //flux it can store 0->N
        //mono only 0->1

        Flux<String> flux = Flux.just("Hello", "World");
//        System.out.println(flux);
        flux.subscribe(System.out::println);

    }

}
