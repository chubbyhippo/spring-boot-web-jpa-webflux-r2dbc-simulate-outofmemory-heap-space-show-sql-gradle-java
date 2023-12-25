package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests extends AbstractTestcontainers {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeAll
    static void setUp() {
        postgresql.start();
    }

    @AfterAll
    static void tearDown() {
        postgresql.stop();
    }

    @Test
    void shouldGetStudents() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/students")
                        .build())
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
