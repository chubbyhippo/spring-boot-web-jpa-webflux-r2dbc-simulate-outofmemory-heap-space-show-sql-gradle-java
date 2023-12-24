package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface StudentR2dbcRepository extends R2dbcRepository<Student, Long> {
}
