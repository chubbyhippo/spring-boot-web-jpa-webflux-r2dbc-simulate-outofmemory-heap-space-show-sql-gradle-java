package io.github.chubbyhippo.demo.infrastructure;

import io.github.chubbyhippo.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
}
