package com.example.demo.domain;

import lombok.Builder;

@Builder
public record Student(Long id, String name) {
}
