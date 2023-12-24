package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Qualifier("r2dbcRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentR2dbcRepository studentR2dbcRepository;

    @Override
    public Flux<Student> findAll() {
        return studentR2dbcRepository.findAll();
    }


}
