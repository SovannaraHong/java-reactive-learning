package com.spring_reactive_company.java_reactive.com.flux.Exercise;

import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class readTextWithFlux {
    void main() {
        Path path = Paths.get("./src/main/resources/file01.txt");
        readText(path).subscribe(Util.subscriber());
    }

    private Flux<String> readText(Path path) {
        return Flux.generate(openFile(path), read(), closeFile());
    }

    private Callable<BufferedReader> openFile(Path path) {
        return () -> Files.newBufferedReader(path);

    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (reader, sink) -> {
            try {
                String line = reader.readLine();
                if (Objects.isNull(line)) {
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return reader;
        };
    }

    private Consumer<BufferedReader> closeFile() {
        return (reader) -> {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
