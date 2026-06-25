package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.flux.Service.OrderService;
import com.spring_reactive_company.java_reactive.com.flux.Service.UserService;
import com.spring_reactive_company.java_reactive.com.utils.Util;

public class O10FlatMap {
    void main() {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        userService.getUsers()
                .flatMap(x -> orderService.getOrders(x.getId()))
                .subscribe(Util.subscriber());
        Util.delay(2);
    }

}
