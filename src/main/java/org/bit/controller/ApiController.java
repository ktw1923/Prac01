package org.bit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping(value = "/demo-web", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> demoWeb() {
        List<String> response = new ArrayList<>();
        response.add("리액트 스프링");
        response.add("연결 성공");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
