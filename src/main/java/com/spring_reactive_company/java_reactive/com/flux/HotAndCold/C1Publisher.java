package com.spring_reactive_company.java_reactive.com.flux.HotAndCold;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class C1Publisher {
    private static Stream<String> getScene() {
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6");
    }

    void main() {

        // it like watch netflix who watch first it completed first
        Flux<String> flux = Flux.fromStream(() -> getScene())
                .delayElements(Duration.ofSeconds(2));
        flux.subscribe(Util.subscriber("Lin"));
        Util.sleep(5);
        flux.subscribe(Util.subscriber("Ra"));
        Util.sleep(50);


    }

}
