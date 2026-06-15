package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

public class flux3WithMultiple {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        flux
                .filter(integer -> integer % 2 == 0)
                .subscribe(x -> System.out.println("Subscribed 1 : " + x));
        flux.subscribe(x -> System.out.println("Subscribed 2 : " + x));

    }
}
