package io.github.chubbyhippo.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
class WhenCallingOnly10StudentsTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("should get http status ok")
    void shouldGetHttpStatusOk() {

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/10students")
                        .build())
                .exchange()
                .expectStatus()
                .isOk();
    }

}
