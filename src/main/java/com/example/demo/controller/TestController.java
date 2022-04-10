package com.example.demo.controller;

import com.example.demo.payload.TestDTO;
import com.example.demo.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public ResponseEntity<Object> helloWorld() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping(path = "/uniqueText", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> uniqueText(TestDTO input) {

        return testService.uniqueText(input);

    }

}
