package com.example.demo.presentation;

import com.example.demo.application.StudentDto;
import com.example.demo.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public Flux<StudentDto> getStudent() {
        return studentService.getStudents()
                .take(1000000);
    }

    @GetMapping("/students/next")
    public Mono<StudentDto> getStudentNext() {
        return studentService.getStudents().next();
    }
}
