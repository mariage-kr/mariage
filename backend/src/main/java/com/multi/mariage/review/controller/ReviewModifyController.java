package com.multi.mariage.review.controller;

import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewModifyController {

    @PostMapping("/user/review/save")
    public ResponseEntity<ReviewSaveResponse> save(@RequestBody ReviewSaveRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
