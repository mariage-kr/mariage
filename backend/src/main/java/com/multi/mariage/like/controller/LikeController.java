package com.multi.mariage.like.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.like.dto.response.LikeCountResponse;
import com.multi.mariage.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/user/review/like")
    public ResponseEntity<LikeCountResponse> like(@Authenticated AuthMember authMember, @RequestBody LikeSaveRequest request) {
        LikeCountResponse response = likeService.save(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/user/review/like")
    public ResponseEntity<LikeCountResponse> cancel(@Authenticated AuthMember authMember,
                                                    @Param("reviewId") Long reviewId) {
        LikeCountResponse response = likeService.remove(authMember, reviewId);
        return ResponseEntity.ok(response);
    }
}
