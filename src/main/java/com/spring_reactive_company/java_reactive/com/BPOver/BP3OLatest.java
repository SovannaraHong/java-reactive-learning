package com.spring_reactive_company.java_reactive.com.BPOver;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP3OLatest {
    //   Queues
    void main() {
        System.setProperty("reactor.bufferSize.small", "16");

        //75 of 16 =12
        //68-88
        Flux.create(sink -> {
                    for (int i = 1; i < 501; i++) {
                        System.out.println("Pushed = " + i);
                        Util.sleepMili(1);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())

                .doOnNext(s -> Util.sleepMili(10))
                .subscribe(Util.subscriber());
        Util.sleep(60);
    }

}
