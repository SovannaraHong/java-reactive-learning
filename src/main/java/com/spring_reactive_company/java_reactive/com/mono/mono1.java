package com.spring_reactive_company.java_reactive.com.mono;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Mono;

public class mono1 {
    public static void main(String[] args) {
        Mono<Integer> mono1 = Mono.just(1);
        mono1.subscribe(
                x -> System.out.println(x),
                x -> System.out.println(x.getMessage()),
                () -> System.out.println("complete")

        );
        Mono<String> mono2 = Mono.just("Hello").map(String::toUpperCase);
        mono2.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
