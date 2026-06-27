package com.spring_reactive_company.java_reactive.com.CombinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class CP3Zip {
    private static Flux<String> getBody() {
        return Flux.just("body1", "body2", "body3");
    }

    private static Flux<String> getEngine() {
        return Flux.just("engine1", "engine2");
    }

    private static Flux<String> getTries() {
        return Flux.just("tries1", "tries2", "tries3");
    }

    void main() {

        //it tags small number engine
        Flux.zip(getBody(), getEngine(), getTries())
                .doOnNext(car -> {
                    car.getT1();
                })
                .subscribe(Util.subscriber());
    }

}
