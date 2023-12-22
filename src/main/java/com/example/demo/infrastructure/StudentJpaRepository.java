package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
}
