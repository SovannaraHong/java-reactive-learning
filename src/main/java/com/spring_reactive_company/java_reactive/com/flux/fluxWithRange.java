package com.spring_reactive_company.java_reactive.com.flux;

import reactor.core.publisher.Flux;

public class fluxWithRange {
    public static void main(String[] args) {
        Flux.range(5, 10)
                .subscribe(System.out::println);
        //end,start
        //cardinal = end-start+1
        //end =cardinal +start-1;
        Flux.range(1, 5)
                .map(x -> "hello world" + x)
                .subscribe(System.out::println);
    }
}
