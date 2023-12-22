package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    @Override
    public List<Student> find10Students() {
        var pageRequest = PageRequest.of(0, 10);
        return studentJpaRepository.findAll(pageRequest)
                .stream()
                .toList();
    }
}
