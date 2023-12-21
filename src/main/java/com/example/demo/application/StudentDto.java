package com.example.demo.application;

import lombok.Builder;

@Builder
public record StudentDto(Long id, String name) {
}
