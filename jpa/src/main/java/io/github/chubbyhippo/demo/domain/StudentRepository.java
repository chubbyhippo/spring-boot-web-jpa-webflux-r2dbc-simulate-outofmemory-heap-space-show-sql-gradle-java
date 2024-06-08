package io.github.chubbyhippo.demo.domain;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    List<Student> find10Students();
}
