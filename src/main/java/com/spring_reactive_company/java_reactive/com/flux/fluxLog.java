package com.spring_reactive_company.java_reactive.com.flux;

import net.datafaker.Faker;
import reactor.core.publisher.Flux;

public class fluxLog {
    public static void main(String[] args) {

        Faker faker = new Faker();

        Flux.range(5, 6)
                .log()
                .map(i -> faker.country().name())
                .log()
                .subscribe(System.out::println);
    }

}
