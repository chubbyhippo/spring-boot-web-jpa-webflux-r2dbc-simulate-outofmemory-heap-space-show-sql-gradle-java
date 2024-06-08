package io.github.chubbyhippo.demo.infrastructure;

import io.github.chubbyhippo.demo.AbstractTestcontainers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentJpaRepositoryTest extends AbstractTestcontainers {

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @BeforeAll
    static void setUp() {
        postgresql.start();
    }

    @AfterAll
    static void tearDown() {
        postgresql.stop();
    }

    @Test
    @DisplayName("should throw out of memory error")
    void shouldThrowOutOfMemoryError() {
        assertThatThrownBy(() -> studentJpaRepository.findAll())
                .isInstanceOf(RuntimeException.class)
                .hasCauseInstanceOf(OutOfMemoryError.class)
                .hasMessage("java.lang.OutOfMemoryError: Java heap space");
    }
}