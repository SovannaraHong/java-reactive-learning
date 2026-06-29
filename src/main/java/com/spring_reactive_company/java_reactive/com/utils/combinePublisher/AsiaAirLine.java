package com.spring_reactive_company.java_reactive.com.utils.combinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AsiaAirLine {
    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .map(x -> "Asia Air Line" + Util.faker().random().nextInt(500, 600))
                .delayElements(Duration.ofSeconds(1))
                .filter(x -> Util.faker().random().nextBoolean());
    }

}
