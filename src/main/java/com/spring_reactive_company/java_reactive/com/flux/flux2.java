package com.spring_reactive_company.java_reactive.com.flux;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class flux2 {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);
        flux
                .map(String::valueOf)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
