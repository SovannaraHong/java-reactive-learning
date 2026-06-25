package com.spring_reactive_company.java_reactive.com.flux.entity;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import lombok.Data;

@Data
public class User {
    private Integer Id;
    private String Name;

    public User(Integer Id) {
        this.Id = Id;
        this.Name = Util.faker().name().firstName();
    }
}
