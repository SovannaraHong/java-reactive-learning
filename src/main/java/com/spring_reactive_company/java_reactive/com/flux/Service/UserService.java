package com.spring_reactive_company.java_reactive.com.flux.Service;

import com.spring_reactive_company.java_reactive.com.flux.entity.User;
import reactor.core.publisher.Flux;

public class UserService {
    public Flux<User> getUsers() {
        return Flux.range(1, 2)
                .map(x -> new User(x));

    }

}
