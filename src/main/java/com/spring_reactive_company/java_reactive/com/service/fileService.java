package com.spring_reactive_company.java_reactive.com.service;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileService {
    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> ReadFile(fileName));

    }

    private static String ReadFile(String fileName) {
        Path path = Paths.get("src/main/resources/");
        try {
            return Files.readString(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
