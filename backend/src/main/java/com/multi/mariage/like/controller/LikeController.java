package com.multi.mariage.like.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
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

    /* TODO: 2023/05/26 like, cancel 반환 값으로 좋아요 수를 반환하기 */
    @PostMapping("/user/review/like")
    public ResponseEntity<Void> like(@Authenticated AuthMember authMember, @RequestBody LikeSaveRequest request) {
        likeService.save(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/user/review/like")
    public ResponseEntity<Void> cancel(@Authenticated AuthMember authMember,
                                       @Param("reviewId") Long reviewId) {
        likeService.remove(authMember, reviewId);
        return ResponseEntity.ok().build();
    }
}
