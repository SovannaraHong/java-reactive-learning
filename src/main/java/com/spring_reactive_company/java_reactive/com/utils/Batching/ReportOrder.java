package com.spring_reactive_company.java_reactive.com.utils.Batching;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ReportOrder {
    private LocalDateTime dateTime;
    private Map<String, Double> orders;

    public ReportOrder(Map<String, Double> orders) {
        this.orders = orders;
        this.dateTime = LocalDateTime.now();
    }
}
