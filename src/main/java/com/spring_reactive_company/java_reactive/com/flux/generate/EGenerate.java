package com.spring_reactive_company.java_reactive.com.flux.generate;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class EGenerate {
    void main() {
//        Flux.generate(sink -> {
//            sink.next("Hello World");
////            sink.next("Hello World");// can not call 2 times
//
//        }).subscribe(Util.subscriber());
//
//

//        Flux.generate(sink -> {
//            String name = Util.faker().country().name();
//
//            System.out.println("Emitting: " + name);
//            if (name.equalsIgnoreCase("brazil")) {
//                sink.complete();
//            } else {
//                sink.next(name);
//            }
//        }).subscribe(Util.subscriber());


        //-------------it work but it's not good because it can increment outside

//        AtomicInteger atomicInteger = new AtomicInteger(0);
//        Flux.generate(sink -> {
//            String name = Util.faker().country().name();
//            sink.next(name);
//            atomicInteger.incrementAndGet();
//            if (atomicInteger.get() > 10) {
//                sink.complete();
//            }
//        }).subscribe(Util.subscriber());
        //-------------this is style make the code good
        Flux.generate(() -> 1, (counter, sink) -> {
            String name = Util.faker().country().name();
            sink.next(name);
            if (counter == 10) {
                sink.complete();
            }
            return counter + 1;
        }).subscribe(Util.subscriber());
//
//        Flux.range(1, 1000)
//                .map(i -> "Line " + i)
//                .subscribe(Util.subscriber());
//

    }
}
