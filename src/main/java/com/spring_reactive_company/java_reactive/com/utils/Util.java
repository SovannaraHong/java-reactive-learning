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

    public static void sleep(int seconds) {
        sleepMili(seconds * 1000);
    }

    public static void sleepMili(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static CustomSub subscriber() {
        return new CustomSub();

    }

    public static CustomSub subscriber(String name) {
        return new CustomSub(name);

    }


    public static Faker faker() {
        return new Faker();
    }
}
