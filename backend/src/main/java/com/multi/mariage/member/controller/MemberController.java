package com.multi.mariage.member.controller;

import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
