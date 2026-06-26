package com.spring_reactive_company.java_reactive.com.BPOver;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP1Overflow {
    //OverFlow Strategy:
    // buffer: keep in memory it is default
    //drop: once the queue is full, new items will be dropped.
    //lastest: once the queue is full, keep 1 latest item as and when it arrives. drop old.
    // error: throws error to the downstream.

    void main() {
        Flux.create(sink -> {
                    for (int i = 0; i < 501; i++) {
                        System.out.println("Pushed = " + i);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(s -> Util.sleepMili(10))
                .subscribe(Util.subscriber());
        Util.sleep(60);
    }

}
