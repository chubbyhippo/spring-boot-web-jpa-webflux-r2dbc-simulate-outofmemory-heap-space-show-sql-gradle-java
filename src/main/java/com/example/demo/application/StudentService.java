package com.example.demo.application;

import com.example.demo.domain.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Qualifier("jpaRepository")
    private final StudentRepository studentRepository;

    public List<StudentDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toDto)
                .toList();
    }

    public List<StudentDto> get10Students() {
        return studentRepository.find10Students()
                .stream()
                .map(StudentMapper::toDto)
                .toList();
    }
}
