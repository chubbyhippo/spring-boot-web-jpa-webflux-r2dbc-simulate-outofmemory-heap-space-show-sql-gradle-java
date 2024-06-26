package io.github.chubbyhippo.demo.application;

import io.github.chubbyhippo.demo.domain.Student;

public class StudentMapper {
    private StudentMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static StudentDto toDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }

}
