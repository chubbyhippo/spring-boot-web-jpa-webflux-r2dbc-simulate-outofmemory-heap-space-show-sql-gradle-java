package com.example.demo.presentation;

import com.example.demo.application.StudentDto;
import com.example.demo.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/students")
    public Flux<StudentDto> getStudent() {
        return studentService.getStudents();
    }
}
