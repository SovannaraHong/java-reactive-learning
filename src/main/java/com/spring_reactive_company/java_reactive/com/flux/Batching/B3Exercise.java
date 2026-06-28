package com.spring_reactive_company.java_reactive.com.flux.Batching;

import com.spring_reactive_company.java_reactive.com.utils.Batching.OrderBatching;
import com.spring_reactive_company.java_reactive.com.utils.Batching.ReportOrder;
import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class B3Exercise {

    private static Flux<OrderBatching> bookOder() {
        return Flux.interval(Duration.ofMillis(10))
//                .map(OrderBatching::new);
                .map(x -> new OrderBatching());
    }

    private static ReportOrder reportOrder(List<OrderBatching> list) {
        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(
                OrderBatching::getCategory,
                Collectors.summingDouble(OrderBatching::getPrice)
        ));
        return new ReportOrder(map);

    }

    //Humor
    //Fable
    //Horror
    void main() {

        Set set = Set.of("Humor", "Fable", "Horror");
        bookOder()
                .filter(x -> set.contains(x.getCategory()))
                .buffer(Duration.ofSeconds(2))
                .map(x -> reportOrder(x))
                .subscribe(Util.subscriber());
        Util.sleep(50);
    }
}
