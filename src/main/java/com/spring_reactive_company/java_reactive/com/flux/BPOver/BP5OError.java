package com.spring_reactive_company.java_reactive.com.flux.BPOver;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class BP5OError {
    //   Queues
    void main() {
        System.setProperty("reactor.bufferSize.small", "16");

        //75 of 16 =12
        //68-88
        List<Object> list = new ArrayList<Object>();
        Flux.create(sink -> {
                    for (int i = 1; i < 501 && !sink.isCancelled(); i++) {
                        System.out.println("Pushed = " + i);
                        Util.sleepMili(1);
                        sink.next(i);
                    }
                    sink.complete();
                })
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())

                .doOnNext(s -> Util.sleepMili(10))
                .subscribe(Util.subscriber());
        System.out.println(list);
        Util.sleep(60);
    }

}
