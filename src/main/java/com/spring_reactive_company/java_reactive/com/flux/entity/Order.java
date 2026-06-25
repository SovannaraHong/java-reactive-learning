package com.spring_reactive_company.java_reactive.com.flux.entity;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String productName;
    private String Price;


    public Order(Integer id) {
        this.id = id;
        this.productName = Util.faker().commerce().productName();
        this.Price = Util.faker().commerce().price();
    }
}
