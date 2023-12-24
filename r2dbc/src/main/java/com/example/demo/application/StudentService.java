package com.example.demo.application;

import com.example.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Qualifier("r2dbcRepository")
    private final StudentRepository studentJpaRepository;

    public Flux<StudentDto> getStudents() {
        return studentJpaRepository.findAll()
                .map(StudentMapper::toDto);
    }
}
