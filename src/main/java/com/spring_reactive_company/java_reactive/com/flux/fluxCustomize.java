package com.spring_reactive_company.java_reactive.com.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class fluxCustomize {
    void main() {
        Flux<Integer> range = Flux.range(1, 10);
        AtomicReference<Subscription> atomic = new AtomicReference<>();
        range.subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("onSubscribe");
                atomic.set(subscription);

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);

            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError: " + throwable);

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }

        });
        atomic.get().request(5);
        atomic.get().request(5);
        atomic.get().cancel();


    }
}
