package com.spring_reactive_company.java_reactive.com.flux.HotAndCold;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class H1Share {
    private static Stream<String> getScene() {
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6");
    }

    void main() {

        // it like watch TV it completed the same time
        Flux<String> flux = Flux.fromStream(() -> getScene())
                .delayElements(Duration.ofSeconds(2))
                .share();
        flux.subscribe(Util.subscriber("Lin"));
        Util.delay(5);
        flux.subscribe(Util.subscriber("Ra"));
        Util.delay(50);


    }

}
