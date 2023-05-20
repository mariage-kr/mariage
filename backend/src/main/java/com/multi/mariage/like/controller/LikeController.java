package com.multi.mariage.like.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.like.dto.request.LikeRemoveRequest;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/user/like/save")
    public ResponseEntity<Void> save(@Authenticated AuthMember authMember, @RequestBody LikeSaveRequest request) {
        likeService.save(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/user/like/remove")
    public ResponseEntity<Void> remove(@Authenticated AuthMember authMember, @RequestBody LikeRemoveRequest request) {
        likeService.remove(authMember, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
