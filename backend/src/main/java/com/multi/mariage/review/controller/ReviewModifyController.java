package com.multi.mariage.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewModifyController {

    @PostMapping("/user/review/save")
    public ResponseEntity<Long> save(){

        return ResponseEntity.status(HttpStatus.CREATED).body(1L);
    }
}
