package com.spring_reactive_company.java_reactive.com.flux.HotAndCold;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class H6PublicCache {
    private static Stream<String> getScene() {
        System.out.println("Streaming video start for watch now ....");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6");
    }

    void main() {

        Flux<String> flux = Flux.fromStream(() -> getScene())
                .delayElements(Duration.ofSeconds(1))
                .cache();

        Util.sleep(3);
        flux.subscribe(Util.subscriber("Dara"));

        Util.sleep(10);
        System.out.println("Thida is about to join...");
        flux.subscribe(Util.subscriber("Thida"));

        Util.sleep(60);


    }

}
