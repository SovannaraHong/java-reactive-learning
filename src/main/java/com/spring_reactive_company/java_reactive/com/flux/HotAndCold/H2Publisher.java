package com.spring_reactive_company.java_reactive.com.flux.HotAndCold;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class H2Publisher {
    private static Stream<String> getScene() {
        System.out.println("Streaming video start for watch now ....");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6");
    }

    void main() {

        Flux<String> flux = Flux.fromStream(() -> getScene())
                .delayElements(Duration.ofSeconds(2))
                .publish()
                .refCount(1);// count subscribe and if it is having subscribe like 2 if it's have 2 sub it do
        // if input 2 it wait subscribe 2 it do
        flux.subscribe(Util.subscriber("Lin"));
        Util.sleep(5);
        flux.subscribe(Util.subscriber("Ra"));
        Util.sleep(50);


    }

}
