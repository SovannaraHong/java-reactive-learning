package com.spring_reactive_company.java_reactive.com.utils.combinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class StringGenerateName {
    static List<String> nameList = new ArrayList<>();

    public static Flux<String> getName() {
        return Flux.generate(sink -> {

                    String s = Util.faker().name().firstName();
                    System.out.println("Your name is " + s);
                    nameList.add(s);
                    Util.sleep(1);

                    sink.next(s);//second
                })
                .cast(String.class)
                .startWith(cachesName());// first

    }

    public static Flux<String> cachesName() {
        return Flux.fromIterable(nameList);
    }
}
