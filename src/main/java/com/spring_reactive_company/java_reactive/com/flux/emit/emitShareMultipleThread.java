package com.spring_reactive_company.java_reactive.com.flux.emit;

import com.spring_reactive_company.java_reactive.com.utils.ColorProduce;
import reactor.core.publisher.Flux;

public class emitShareMultipleThread {
    void main() {

        ColorProduce color = new ColorProduce();
        Flux.create(color).subscribe(System.out::println);

        Runnable runnable = () -> ColorProduce.produce();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
