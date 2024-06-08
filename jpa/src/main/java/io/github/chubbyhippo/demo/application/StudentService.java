package io.github.chubbyhippo.demo.application;

import io.github.chubbyhippo.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Qualifier("jpaRepository")
    private final StudentRepository studentJpaRepository;

    public List<StudentDto> getStudents() {
        return studentJpaRepository.findAll()
                .stream()
                .map(StudentMapper::toDto)
                .toList();
    }

    public List<StudentDto> get10Students() {
        return studentJpaRepository.find10Students()
                .stream()
                .map(StudentMapper::toDto)
                .toList();
    }
}
