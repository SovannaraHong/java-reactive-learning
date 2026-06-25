package com.spring_reactive_company.java_reactive.com.utils;

import lombok.Data;

@Data
public class Student {
    private String name;
    private Integer age;

    public Student() {
        this.name = Util.faker().name().firstName();
        this.age = Util.faker().random().nextInt(10, 20);
    }
}
