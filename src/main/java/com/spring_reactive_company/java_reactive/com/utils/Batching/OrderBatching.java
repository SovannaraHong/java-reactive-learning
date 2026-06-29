package com.spring_reactive_company.java_reactive.com.utils.Batching;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import lombok.Data;

@Data
public class OrderBatching {
    private String category;
    private String title;
    private Double price;


    public OrderBatching() {
        this.category = Util.faker().book().genre();
        this.title = Util.faker().book().title();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }

    
}
