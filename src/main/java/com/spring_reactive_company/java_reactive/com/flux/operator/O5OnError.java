package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class O5OnError {
    private static Mono<Integer> getFallBack() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(10, 20));
    }

    void main() {

        Flux.range(1, 10)
                .map(i -> 20 / (6 - i))
                .onErrorReturn(-1)//  replace error by -1
                .subscribe(Util.subscriber());

        Flux.range(1, 10)
                .map(i -> 20 / (6 - i))
//                .onErrorResume(e -> Mono.just(null))// it has return fallBack function
                .onErrorResume(e -> getFallBack())
                .subscribe(Util.subscriber());
        Flux.range(1, 10)
                .map(i -> 20 / (6 - i))
                .onErrorContinue((e, obj) -> {
                    System.out.println("Error: " + obj + "Root cause: " + e);
                }).subscribe(Util.subscriber());
        //------------------------ can do this


    }
}
