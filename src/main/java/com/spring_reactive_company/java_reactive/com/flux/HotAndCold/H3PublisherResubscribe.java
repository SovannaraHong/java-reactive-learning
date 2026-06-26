package com.spring_reactive_company.java_reactive.com.flux.HotAndCold;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class H3PublisherResubscribe {
    private static Stream<String> getScene() {
        System.out.println("Streaming video start for watch now ....");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6");
    }

    void main() {

        //it is like watch movie group first watch and finish waiting time 2 or 3 or more booking for watch too
        Flux<String> flux = Flux.fromStream(() -> getScene())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1);
        flux.subscribe(Util.subscriber("Lin"));
        Util.sleep(10);
        flux.subscribe(Util.subscriber("Ra"));
        Util.sleep(50);


    }

}
