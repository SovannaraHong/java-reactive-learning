package com.spring_reactive_company.java_reactive.com.utils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSub implements Subscriber<Object> {

    private String name = "";

    public CustomSub(String name) {
        this.name = name + '-';
    }

    public CustomSub() {

    }


    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);

    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + "Received" + '-' + o);

    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("error" + '-' + throwable);

    }

    @Override
    public void onComplete() {
        System.out.println("complete" + '-');

    }
}
