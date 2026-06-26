package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class O6Timeout {
    private static Flux<Object> getName() {
        return Flux.generate(() -> 1, (counter, sink) -> {
            String name = Util.faker().country().name();
            System.out.println("emitting: " + name);
            sink.next(name);
            if (name.equalsIgnoreCase("Italy")) {
                sink.complete();
            }
            return counter + 1;
        }).delayElements(Duration.ofSeconds(6));
    }

    //this is fallBackFunction
    private static Flux<Object> getAge() {
        return Flux.generate(() -> 1, (counter, sink) -> {
            if (counter == 10) {
                sink.complete();
            }
            sink.next(Util.faker().random().nextInt(1, 10));
            return counter + 1;
        }).delayElements(Duration.ofSeconds(1));
    }

    void main() {
        getName()
                //second para it fallback
                .timeout(Duration.ofSeconds(3), getAge())// one parameter if timeout small than delay it close
                .subscribe(Util.subscriber());
        Util.sleep(50);

    }
}
