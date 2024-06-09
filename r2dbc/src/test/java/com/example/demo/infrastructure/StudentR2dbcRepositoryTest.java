package com.example.demo.infrastructure;

import com.example.demo.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.context.annotation.Import;
import reactor.test.StepVerifier;

@DataR2dbcTest
@Import(TestcontainersConfiguration.class)
class StudentR2dbcRepositoryTest {

    @Autowired
    private StudentR2dbcRepository studentR2dbcRepository;

    @Test
    @DisplayName("should count all student records")
    void shouldCountAllStudentRecords() {
        StepVerifier.create(studentR2dbcRepository.count())
                .expectNext(1000000L)
                .verifyComplete();
    }

}