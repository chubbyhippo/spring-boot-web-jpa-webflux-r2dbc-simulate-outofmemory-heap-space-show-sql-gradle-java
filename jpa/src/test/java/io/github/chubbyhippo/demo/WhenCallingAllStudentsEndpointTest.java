package io.github.chubbyhippo.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
public class WhenCallingAllStudentsEndpointTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("should get http status error 500")
    void shouldGetHttpStatusError500() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/allStudents")
                        .build())
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
