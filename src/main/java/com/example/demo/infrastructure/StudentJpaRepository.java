package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Long>, StudentRepository {
}
