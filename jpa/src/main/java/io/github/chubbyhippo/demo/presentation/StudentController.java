package io.github.chubbyhippo.demo.presentation;

import io.github.chubbyhippo.demo.application.StudentDto;
import io.github.chubbyhippo.demo.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

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

    @GetMapping("/allStudents")
    @CrossOrigin("*")
    public StreamingResponseBody getAllStudents() {
        return outputStream -> {

            studentService.getAllStudents().forEach(student -> {
                try {
                    outputStream.write(student.toString().getBytes());
                    outputStream.write("\n".getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        };
    }
}
