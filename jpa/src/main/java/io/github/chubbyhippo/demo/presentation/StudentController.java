package io.github.chubbyhippo.demo.presentation;

import io.github.chubbyhippo.demo.application.StudentDto;
import io.github.chubbyhippo.demo.application.StudentService;
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
