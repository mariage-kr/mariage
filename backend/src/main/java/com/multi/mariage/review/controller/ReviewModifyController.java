package com.multi.mariage.review.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.request.ReviewUpdateRequest;
import com.multi.mariage.review.dto.response.ReviewDeleteResponse;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.review.dto.response.ReviewUpdateResponse;
import com.multi.mariage.review.service.ReviewModifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @DeleteMapping("/user/review/{reviewId}")
    public ResponseEntity<ReviewDeleteResponse> delete(@Authenticated AuthMember authMember,
                                                       @PathVariable Long reviewId) {
        reviewModifyService.delete(authMember, reviewId);
        ReviewDeleteResponse response = new ReviewDeleteResponse(reviewId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/user/review/update")
    public ResponseEntity<ReviewUpdateResponse> update(@Authenticated AuthMember authMember,
                                                       @RequestBody ReviewUpdateRequest request) {
        ReviewUpdateResponse response = reviewModifyService.update(authMember, request);

        return ResponseEntity.ok(response);
    }
}
