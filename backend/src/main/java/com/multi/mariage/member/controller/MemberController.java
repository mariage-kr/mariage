package com.multi.mariage.member.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.response.UpdateImageResponse;
import com.multi.mariage.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members/signup")
    public ResponseEntity<Void> signup(@RequestBody MemberSignupRequest request) {
        memberService.signup(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/members/withdraw")
    public ResponseEntity<Void> withdraw(@Authenticated AuthMember authMember) {
        memberService.withdrawalByMember(authMember);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/members/update/image")
    public ResponseEntity<UpdateImageResponse> updateImage(@Authenticated AuthMember authMember,
                                                           MultipartFile file) {
        UpdateImageResponse response = memberService.updateImage(authMember, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/user/members/remove/image")
    public ResponseEntity<Void> removeImage(@Authenticated AuthMember authMember) {
        memberService.removeImage(authMember);
        return ResponseEntity.ok().build();
    }
}
