package com.example.demo.infrastructure;

import com.example.demo.domain.Student;
import com.example.demo.domain.StudentReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@Qualifier("r2dbcRepository")
@RequiredArgsConstructor
public class StudentR2dbcRepositoryImpl implements StudentReactiveRepository {

    private final StudentR2dbcRepository studentR2dbcRepository;

    @Override
    public Flux<Student> getStudents() {
        return studentR2dbcRepository.findAll();
    }
}
