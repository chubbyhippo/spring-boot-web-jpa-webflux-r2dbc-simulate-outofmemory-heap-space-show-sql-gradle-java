package com.example.demo.web;

import com.example.demo.application.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<StudentDto> getStudent() {
        return null;
    }
}
