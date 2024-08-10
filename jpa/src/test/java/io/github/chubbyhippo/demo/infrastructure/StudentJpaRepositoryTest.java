package io.github.chubbyhippo.demo.infrastructure;

import io.github.chubbyhippo.demo.TestcontainersConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestcontainersConfiguration.class)
@Testcontainers(disabledWithoutDocker = true)
class StudentJpaRepositoryTest {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Test
    @DisplayName("should throw out of memory error")
    void shouldThrowOutOfMemoryError() {
        assertThatThrownBy(() -> studentJpaRepository.findAll())
                .isInstanceOf(RuntimeException.class)
                .hasCauseInstanceOf(OutOfMemoryError.class)
                .hasMessage("java.lang.OutOfMemoryError: Java heap space");
    }

    @Test
    @DisplayName("should be able to run")
    void shouldBeAbleToRun() {
        assertThatNoException().isThrownBy(() -> studentJpaRepository.findAllWithStream());
    }
}