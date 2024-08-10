package io.github.chubbyhippo.demo.domain;

import java.util.List;
import java.util.stream.Stream;

public interface StudentRepository {
    List<Student> findAll();
    List<Student> find10Students();
    Stream<Student> findAllStudents();
}
