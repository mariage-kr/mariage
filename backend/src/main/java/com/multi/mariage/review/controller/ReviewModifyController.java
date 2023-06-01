package com.multi.mariage.review.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.request.ReviewModifyRequest;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.response.ReviewModifyResponse;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewModifyController {
    private final ReviewModifyService reviewModifyService;

    @PostMapping("/user/review/save")
    public ResponseEntity<ReviewSaveResponse> save(@Authenticated AuthMember authMember,
                                                   @RequestBody ReviewSaveRequest request) {
        Review review = reviewModifyService.save(authMember, request);
        ReviewSaveResponse response = new ReviewSaveResponse(review.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/user/review/update")
    public ResponseEntity<ReviewModifyResponse> update(@RequestBody ReviewModifyRequest request) {
        Review review = reviewModifyService.update(request);
        ReviewModifyResponse response = new ReviewModifyResponse(review.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
