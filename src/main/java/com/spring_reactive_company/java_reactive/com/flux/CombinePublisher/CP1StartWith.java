package com.spring_reactive_company.java_reactive.com.flux.CombinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import com.spring_reactive_company.java_reactive.com.utils.combinePublisher.StringGenerateName;
import reactor.core.publisher.Flux;

public class CP1StartWith {
    void main() {
        Flux<String> name = StringGenerateName.getName();

        name
                .take(3)
                .subscribe(Util.subscriber("thida"));
        name
                .take(4)
                .subscribe(Util.subscriber("bora"));
        name
                .filter(x -> x.startsWith("T"))
                .take(4)
                .subscribe(Util.subscriber("lina"));
    }


}
