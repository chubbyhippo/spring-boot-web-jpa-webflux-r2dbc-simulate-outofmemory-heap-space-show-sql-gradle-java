package com.example.demo;

import com.example.demo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void shouldGetStudents() {
		webTestClient.get()
				.uri(uriBuilder -> uriBuilder.path("/student")
						.build())
				.exchange()
				.expectBodyList(Student.class);
	}

}
