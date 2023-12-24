package com.example.demo.domain;

import reactor.core.publisher.Flux;

public interface StudentRepository {
    Flux<Student> findAll();
}
