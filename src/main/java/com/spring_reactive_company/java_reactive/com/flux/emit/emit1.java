package com.spring_reactive_company.java_reactive.com.flux.emit;

import com.spring_reactive_company.java_reactive.com.utils.ColorProduce;
import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class emit1 {
    void main() {
        Flux.create(fluxSink -> {
            fluxSink.next("hello");
            fluxSink.next("world");

            fluxSink.complete();
        }).subscribe(System.out::println);

        Flux.create(fluxSink -> {
            fluxSink.next(Util.faker().country().name());
            fluxSink.complete();
        }).subscribe(System.out::println);

        Flux.create(fluxSink -> {
            String name;
            do {
                name = Util.faker().color().name();
                fluxSink.next(name);
            } while (!name.equalsIgnoreCase("yellow"));
            fluxSink.complete();

        }).subscribe(System.out::println);

        System.out.println("------------------------");
        ColorProduce color = new ColorProduce();
        Flux.create(color).subscribe(System.out::println);

        for (int i = 0; i < 10; i++) {
            Util.delay(2);
            ColorProduce.produce();

        }
    }

}
