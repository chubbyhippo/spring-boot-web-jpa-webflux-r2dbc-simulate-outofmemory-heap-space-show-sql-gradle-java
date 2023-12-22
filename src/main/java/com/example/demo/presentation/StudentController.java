package com.example.demo.presentation;

import com.example.demo.application.StudentDto;
import com.example.demo.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/students")
    public List<StudentDto> getStudent() {
        return studentService.getStudents();
    }

    @GetMapping("/10students")
    public List<StudentDto> get10Student() {
        return studentService.get10Students();
    }
}
