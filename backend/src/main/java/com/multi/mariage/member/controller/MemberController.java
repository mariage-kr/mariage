package com.multi.mariage.member.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        memberService.withdrawal(authMember);
        return ResponseEntity.ok().build();
    }
}
