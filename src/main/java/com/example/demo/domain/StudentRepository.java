package com.example.demo.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    List<Student> getStudents();
}
