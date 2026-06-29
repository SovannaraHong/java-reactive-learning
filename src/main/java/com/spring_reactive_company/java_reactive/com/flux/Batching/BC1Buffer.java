package com.spring_reactive_company.java_reactive.com.flux.Batching;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BC1Buffer {
    private static Flux<String> fluxString() {
        return Flux.interval(Duration.ofMillis(300))

                .map(x -> "event - " + x);
    }

    void main() {

        fluxString()
//                .buffer(5)// it batch 5 item send produce data
//                .buffer(Duration.ofSeconds(2)) 2s batch data
                .bufferTimeout(5, Duration.ofSeconds(2))//group 5item in 2s
                .subscribe(Util.subscriber());
        Util.sleep(60);
    }
}
