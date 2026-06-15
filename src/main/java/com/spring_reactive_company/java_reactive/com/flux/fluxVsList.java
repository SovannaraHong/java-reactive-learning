package com.spring_reactive_company.java_reactive.com.flux;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import net.datafaker.Faker;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class fluxVsList {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(getCount(3));
        getCountries(3).subscribe(System.out::println);

    }

    private static String getCountry() {
        Util.delay(1);

        return new Faker().country().name();
    }

    private static List<String> getCount(int number) {
        System.out.println("generate...");
        for (int i = 0; i < number; i++) {
            list.add(getCountry());
        }
        return list;
    }

    private static Flux<String> getCountries(int number) {
        System.out.println("generate...");
        return Flux.range(1, number)
                .map(x -> getCountry());
    }
}
