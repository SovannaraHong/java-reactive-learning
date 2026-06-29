package com.spring_reactive_company.java_reactive.com.flux.Batching;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class BC5GroupBy {
    static AtomicInteger counter = new AtomicInteger(1);

    private static Flux<String> fluxString() {
        return Flux.interval(Duration.ofMillis(100))

                .map(x -> "event - " + x);
    }

    private static Mono<Integer> processItem(Flux<String> flux) {
        return flux
                .doOnNext(x -> System.out.println("saving: " + x))
                .doOnComplete(() -> System.out.println("item saved"))
                .then(Mono.just(counter.incrementAndGet()));

    }

    void main() {
        fluxString()

                .window(5)
                .flatMap(x -> processItem(x))
                .subscribe(Util.subscriber());
        Util.sleep(60);
    }


}
