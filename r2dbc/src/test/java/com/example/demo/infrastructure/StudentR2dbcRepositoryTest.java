package com.example.demo.infrastructure;

import com.example.demo.AbstractTestcontainers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;

@DataR2dbcTest
class StudentR2dbcRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private StudentR2dbcRepository studentR2dbcRepository;

    @BeforeAll
    static void setUp() {
        postgresql.start();
    }

    @AfterAll
    static void tearDown() {
        postgresql.stop();
    }

    @Test
    @DisplayName("should count all student records")
    void shouldCountAllStudentRecords() {
        StepVerifier.create(studentR2dbcRepository.count())
                .expectNext( 1000000L)
                .verifyComplete();
    }

}