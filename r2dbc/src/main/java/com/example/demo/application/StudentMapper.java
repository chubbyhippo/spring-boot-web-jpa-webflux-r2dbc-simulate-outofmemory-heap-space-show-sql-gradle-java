package com.example.demo.application;

import com.example.demo.domain.Student;

public class StudentMapper {
    public static StudentDto toDto(Student student) {
        return StudentDto.builder()
                .id(student.id())
                .name(student.name())
                .build();
    }

}
