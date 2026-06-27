package com.spring_reactive_company.java_reactive.com.CombinePublisher;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import com.spring_reactive_company.java_reactive.com.utils.combinePublisher.AngkorAirLine;
import com.spring_reactive_company.java_reactive.com.utils.combinePublisher.AsiaAirLine;
import reactor.core.publisher.Flux;

public class CP3Merge {
    void main() {
        Flux.merge(AsiaAirLine.getFlights(), AngkorAirLine.getFlights())
                .subscribe(Util.subscriber());
        Util.sleep(10);
    }


}
