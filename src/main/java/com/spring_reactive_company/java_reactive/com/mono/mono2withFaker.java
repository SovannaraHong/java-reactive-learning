package com.spring_reactive_company.java_reactive.com.mono;

import com.spring_reactive_company.java_reactive.com.utils.FakerController;
import com.spring_reactive_company.java_reactive.com.utils.Util;
import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class mono2withFaker {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(faker.name().fullName());

        }
        list.forEach(System.out::println);
        String name = faker.color().name();
        System.out.println(name);

        System.out.println("-------------------------");
        FakerController.getById(1)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
