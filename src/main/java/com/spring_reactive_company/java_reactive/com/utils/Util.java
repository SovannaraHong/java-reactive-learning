package com.spring_reactive_company.java_reactive.com.utils;

import net.datafaker.Faker;

import java.util.function.Consumer;

public class Util {
    public static Consumer<String> onNext() {
        return x -> System.out.println(x);
    }

    public static Consumer<Throwable> onError() {
        return x -> System.out.println(x.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("complete");
    }

    public static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Faker faker() {
        return new Faker();
    }
}
