package com.spring_reactive_company.java_reactive.com.flux.Batching;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BCWindow {
    private static Flux<String> fluxString() {
        return Flux.interval(Duration.ofMillis(300))

                .map(x -> "event - " + x);
    }

    void main() {

        fluxString()

                .subscribe(Util.subscriber());
        Util.sleep(60);
    }


}
