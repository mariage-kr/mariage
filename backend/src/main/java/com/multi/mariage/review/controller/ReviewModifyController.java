package com.multi.mariage.review.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewModifyService;
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
    private final ReviewModifyService reviewModifyService;

    @PostMapping("/user/review/save")
    public ResponseEntity<ReviewSaveResponse> save(@Authenticated AuthMember authMember,
                                                   @RequestBody ReviewSaveRequest request) {
        System.out.println(request.getHashtags());
//        ReviewSaveResponse response = reviewModifyService.save(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
