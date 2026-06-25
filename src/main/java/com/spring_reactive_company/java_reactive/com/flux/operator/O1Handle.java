package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class O1Handle {
    void main() {

//        Flux.range(1, 10)
//                .filter(e -> e % 2 == 0)
//                .subscribe(Util.subscriber());

        //handle Operator = filter +map
//        Flux.range(1, 10)
//                .handle((num, sink) -> {
//                    if (num > 5) {
//                        sink.complete();
//                    } else {
//                        sink.next(num);
//                    }
//                }).subscribe(Util.subscriber());


        Flux.generate(sink -> {
                    sink.next(Util.faker().country().name());
                }).map(x -> x.toString())
                .handle((name, sink) -> {
                    if (name.equalsIgnoreCase("brazil")) {
                        sink.complete();
                    } else {
                        sink.next(name);
                    }
                }).subscribe(Util.subscriber());
    }

}
