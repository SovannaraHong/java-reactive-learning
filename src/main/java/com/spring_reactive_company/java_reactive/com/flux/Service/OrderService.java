package com.spring_reactive_company.java_reactive.com.flux.Service;

import com.spring_reactive_company.java_reactive.com.flux.entity.Order;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    static Map<Integer, List<Order>> db = new HashMap<>();

    static {
        List<Order> order1 = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );
        List<Order> order2 = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );
        List<Order> order3 = List.of(
                new Order(1),
                new Order(2),
                new Order(3)
        );
        db.put(1, order1);
        db.put(2, order2);
    }

    public Flux<Order> getOrders(int id) {
        return Flux.create(fluxSink -> {
            db.get(id).forEach(fluxSink::next);
            fluxSink.complete();
        });
    }

}
