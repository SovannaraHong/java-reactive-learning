package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class O7DefaultIsEmpty {
    private static Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> getNumbers1() {
        return Flux.range(55, 100);
    }

    private static Flux<Object> fallBack() {
        return Flux.generate(sink -> {
            String name = Util.faker().color().name();
            if (name.equalsIgnoreCase("yellow")) sink.complete();
            sink.next(name);

        }).delayElements(Duration.ofSeconds(1));
    }

    void main() {
        getNumbers()
                .filter(num -> num > 10)
//                .defaultIfEmpty(100)// is empty
                .switchIfEmpty(getNumbers1())
                .subscribe(Util.subscriber());

    }

}
