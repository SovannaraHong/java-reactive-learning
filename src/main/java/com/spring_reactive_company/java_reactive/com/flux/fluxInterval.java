package com.spring_reactive_company.java_reactive.com.flux;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class fluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)).subscribe(System.out::println);
        Util.delay(3);
    }
}
