package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class fluxFromStream {
    public static void main(String[] args) {
        //from stream
        List<Integer> integers = List.of(123);
        Stream<Integer> stream = integers.stream();
        Flux.fromStream(stream).subscribe(System.out::println);

//        Flux.fromStream(stream).subscribe(System.out::println);

        //from supplier stream | use this because stream  when meet terminal it can not reuse but use supplier stream it can
        Flux.fromStream(integers.stream()).subscribe(System.out::println);
        Flux.fromStream(integers.stream()).subscribe(System.out::println);

    }
}
