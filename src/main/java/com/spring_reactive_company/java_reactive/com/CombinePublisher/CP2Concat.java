package com.spring_reactive_company.java_reactive.com.CombinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class CP2Concat {
    void main() {
        Flux<String> flux1 = Flux.just("Hello", "World");//start first
        Flux<String> flux2 = Flux.just("it me", "akira");
        Flux<Object> flux3 = Flux.error(new RuntimeException("something was wrong"));
        flux1.concatWith(flux2).subscribe(Util.subscriber());
        Flux

                .concatDelayError(flux1, flux3, flux2).subscribe(Util.subscriber());

    }


}
