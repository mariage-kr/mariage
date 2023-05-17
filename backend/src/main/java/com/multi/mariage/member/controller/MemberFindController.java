package com.multi.mariage.member.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.dto.response.MyInfoResponse;
import com.multi.mariage.member.dto.response.MemberInfoResponse;
import com.multi.mariage.member.service.MemberFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class MemberFindController {

    private final MemberFindService memberService;

    @GetMapping("/user/members/profile")
    public ResponseEntity<MyInfoResponse> findMemberProfile(@Authenticated AuthMember authMember) {
        MyInfoResponse response = memberService.findMemberProfile(authMember);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/members/info")
    public ResponseEntity<MemberInfoResponse> findMemberInfo(@Authenticated AuthMember authMember) {
        MemberInfoResponse response = memberService.findMemberInfo(authMember);
        return ResponseEntity.ok(response);
    }
}
