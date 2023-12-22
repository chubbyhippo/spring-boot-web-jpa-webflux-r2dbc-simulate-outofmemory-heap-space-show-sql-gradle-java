package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests extends AbstractTestcontainers {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldGetStudents() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/students")
                        .build())
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    @DisplayName("should get 10 students")
    void shouldGet10Students() {

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/10students")
                        .build())
                .exchange()
                .expectStatus()
                .isOk();
    }

}
