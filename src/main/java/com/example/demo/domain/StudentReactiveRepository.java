package com.example.demo.domain;

import reactor.core.publisher.Flux;

public interface StudentReactiveRepository {
    Flux<Student> getStudents();
}
