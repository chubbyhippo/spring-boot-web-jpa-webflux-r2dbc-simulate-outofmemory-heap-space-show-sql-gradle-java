package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
class DemoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

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
