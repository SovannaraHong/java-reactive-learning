package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

public class O3LimitRate {
    void main() {

        // 75% request
        Flux.range(1, 100)
                .log()
//                .limitRate(10)// 1 parameter
//                .limitRate(10, 10) // like this it goes to default
//                .limitRate(10, 2)// request 2
                .limitRate(10, 0)// it 10 request
                .subscribe(Util.subscriber());
    }
}
