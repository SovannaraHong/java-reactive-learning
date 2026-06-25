package com.spring_reactive_company.java_reactive.com.Thread;

import reactor.core.publisher.Flux;

public class T1DefaultThread {
    private static void printThread(String threadName) {
        System.out.println(threadName + "Thread Name: " + Thread.currentThread().getName());
    }

    void main() {
        Flux<Object> flux = Flux.create(sink -> {
            printThread("create");
            sink.next(10);


        }).doOnNext(x -> printThread("next" + x));


        Runnable r = () -> flux.subscribe(x -> printThread("subscribe" + x));
        for (int i = 0; i < 2; i++) {
            new Thread(r).start();
        }

    }


}
