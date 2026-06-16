package com.spring_reactive_company.java_reactive.com.flux.emit;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class TakeOperator {
    void main() {
        Flux.range(1, 10)
                .take(3)
                .subscribe(System.out::println);


        Flux.create(sink -> {
                    String name;
                    do {
                        name = Util.faker().color().name();
                        System.out.println("Emitting: " + name);
                        sink.next(name);
                    } while (!name.equalsIgnoreCase("yellow") && !sink.isCancelled());
                    sink.complete();
                }).take(3)
                .subscribe(System.out::println);
    }
}
