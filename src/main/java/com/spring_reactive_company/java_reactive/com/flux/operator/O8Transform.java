package com.spring_reactive_company.java_reactive.com.flux.operator;

import com.spring_reactive_company.java_reactive.com.utils.Student;
import com.spring_reactive_company.java_reactive.com.utils.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class O8Transform {
    private static Flux<Student> getStudents() {
        return Flux.range(1, 10)
                .map(x -> new Student())
                ;
    }

    private static Function<Flux<Student>, Flux<Student>> getStudents2() {
        return flux -> flux.filter(student -> student.getAge() > 18)
                .doOnNext(x -> x.setName(x.getName().toUpperCase()))
                .doOnDiscard(Student.class, x -> System.out.println("Student Not Allows" + x))
                ;
    }

    private static Function<Flux<Student>, Flux<Student>> getStudents3() {
        return flux -> flux.filter(student -> student.getAge() > 18)
                .map(x -> {
                    x.setName(x.getName().toUpperCase());
                    return x;
                })
                ;
    }

    void main() {

        getStudents()
                .transform(getStudents2())
                .subscribe(Util.subscriber());

    }

}
