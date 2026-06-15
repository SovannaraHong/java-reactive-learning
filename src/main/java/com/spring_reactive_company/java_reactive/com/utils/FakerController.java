package com.spring_reactive_company.java_reactive.com.utils;


import net.datafaker.Faker;
import reactor.core.publisher.Mono;

public class FakerController {
    static Faker faker = new Faker();

    public static Mono<String> getById(int id) {
        if (id == 1) {
            return Mono.just(faker.country().name());
        } else if (id == 2) {
            return Mono.just(faker.name().fullName());
        }
        return Mono.error(new RuntimeException());

    }
}
