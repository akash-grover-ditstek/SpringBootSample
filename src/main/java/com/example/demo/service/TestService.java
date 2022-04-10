package com.example.demo.service;

import com.example.demo.payload.TestDTO;

import org.springframework.http.ResponseEntity;

public interface TestService {
    public ResponseEntity<Object> uniqueText(TestDTO input);
}
