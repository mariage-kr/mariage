package com.multi.mariage.review.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.review_hashtag.service.ReviewHashtagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewModifyController {
    private final ReviewModifyService reviewModifyService;
    private final ReviewHashtagService reviewHashtagService;

    @PostMapping("/user/review/save")
    public ResponseEntity<ReviewSaveResponse> save(@Authenticated AuthMember authMember,
                                                   @RequestBody ReviewSaveRequest request) {
        ReviewSaveResponse response = reviewModifyService.save(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{reviewId}/hashtags/{hashtagId}")
            public ResponseEntity<String> removeHashtagFromReview(@PathVariable Long reviewId,
                                                                  @PathVariable Long hashtagId) {

        boolean removed = reviewHashtagService.removeHashtagFromReview(reviewId, hashtagId);

        if (removed) {
            return ResponseEntity.ok("Hashtag removed from review successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
