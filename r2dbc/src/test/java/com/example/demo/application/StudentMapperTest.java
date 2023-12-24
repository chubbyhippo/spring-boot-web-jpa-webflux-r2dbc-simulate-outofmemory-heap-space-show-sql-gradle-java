package com.example.demo.application;

import com.example.demo.domain.Student;
import org.junit.jupiter.api.Test;

import static com.example.demo.application.StudentMapper.toDto;
import static org.assertj.core.api.Assertions.assertThat;

class StudentMapperTest {

    @Test
    void shouldConvertEntityToDto() {
        var student = Student.builder()
                .id(1L)
                .name("Test")
                .build();

        var studentDto = StudentDto.builder()
                .id(1L)
                .name("Test")
                .build();

        assertThat(toDto(student)).isEqualTo(studentDto);
    }
}