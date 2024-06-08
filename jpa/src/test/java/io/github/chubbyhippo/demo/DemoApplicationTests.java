package io.github.chubbyhippo.demo;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(2)
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
    @Order(1)
    void shouldGet10Students() {

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/10students")
                        .build())
                .exchange()
                .expectStatus()
                .isOk();
    }

}
