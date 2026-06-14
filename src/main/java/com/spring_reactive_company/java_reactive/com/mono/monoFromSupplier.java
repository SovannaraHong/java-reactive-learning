package com.spring_reactive_company.java_reactive.com.mono;

import com.spring_reactive_company.java_reactive.com.service.fileService;
import com.spring_reactive_company.java_reactive.com.utils.Util;
import net.datafaker.Faker;
import reactor.core.publisher.Mono;

public class monoFromSupplier {
    public static void main(String[] args) {


        //we use just when have already data
//        Mono<String> mono = Mono.just(getName());
        Mono.fromSupplier(() -> getName()).map(String::toUpperCase)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        System.out.println("-=-----------------------");
        generateName().subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        System.out.println("-=-----------------------");
        fileService.read("student.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static String getName() {
        System.out.println("Generate Name......");
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    private static Mono<String> generateName() {
        System.out.println("Entering Method........");
        return Mono.fromSupplier(() -> {
            System.out.println("GenerateName ..........");
            Faker faker = new Faker();
            Util.delay(2);
            return faker.name().firstName();
        }).map(String::toUpperCase);
    }
}
