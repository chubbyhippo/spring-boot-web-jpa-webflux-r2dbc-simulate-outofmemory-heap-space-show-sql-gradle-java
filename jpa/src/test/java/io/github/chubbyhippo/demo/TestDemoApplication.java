package io.github.chubbyhippo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration(proxyBeanMethods = false)
@ImportTestcontainers(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
public class TestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.from(DemoApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }

}
