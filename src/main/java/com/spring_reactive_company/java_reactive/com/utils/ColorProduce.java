package com.spring_reactive_company.java_reactive.com.utils;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class ColorProduce implements Consumer<FluxSink<String>> {
    private static FluxSink<String> sink;

    public static void produce() {
        String name = Thread.currentThread().getName();
        sink.next(name + " - " + Util.faker().color().name());
    }

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        sink = stringFluxSink;
//        sink.next(Util.faker().color().name());
    }
}
