package com.spring_reactive_company.java_reactive.com.Thread;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class T2SubscribeOn {
    private static void printThread(String threadName) {
        System.out.println(threadName + " - " + Thread.currentThread().getName());
    }

    void main() {
        Flux<Object> flux = Flux.create(sink -> {
                    printThread("create");
                    sink.next(10);


                }).subscribeOn(Schedulers.newParallel("nara"))
                .doOnNext(x -> printThread("next" + x));
        flux
                .doFirst(() -> printThread("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThread("first1"))
                .subscribe(x -> printThread("sub" + x));
        Util.sleep(50);
//        Runnable r = () -> flux.subscribe(x -> printThread("subscribe" + x));
//        for (int i = 0; i < 2; i++) {
//            new Thread(r).start();
//        }

    }


}
