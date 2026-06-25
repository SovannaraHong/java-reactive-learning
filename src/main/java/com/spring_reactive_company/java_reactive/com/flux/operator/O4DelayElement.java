package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.spring_reactive_company.java_reactive.com.utils.Util.subscriber;

public class O4DelayElement {
    void main() {
        Flux.range(1, 100)
                .log()
                .limitRate(10)

                .delayElements(Duration.ofSeconds(1))//delay of element
                .subscribe(subscriber());
        Util.delay(60);


    }
}
