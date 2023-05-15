package com.multi.mariage.member.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.request.UpdateNicknameRequest;
import com.multi.mariage.member.dto.request.UpdatePasswordRequest;
import com.multi.mariage.member.dto.response.MyInfoResponse;
import com.multi.mariage.member.dto.response.NicknameResponse;
import com.multi.mariage.member.dto.response.UpdateImageResponse;
import com.multi.mariage.member.dto.response.UpdateNicknameResponse;
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

    @PostMapping("/user/members/image")
    public ResponseEntity<UpdateImageResponse> updateImage(@Authenticated AuthMember authMember,
                                                           MultipartFile file) {
        UpdateImageResponse response = memberService.updateImage(authMember, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/user/members/find")
    public ResponseEntity<MyInfoResponse> findMemberInfo(@Authenticated AuthMember authMember) {
        MyInfoResponse response = memberService.findMemberInfo(authMember);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/user/members/image")
    public ResponseEntity<Void> removeImage(@Authenticated AuthMember authMember) {
        memberService.removeImage(authMember);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/members/nickname")
    public ResponseEntity<UpdateNicknameResponse> updateNickname(@Authenticated AuthMember authMember,
                                                                 @RequestBody UpdateNicknameRequest request) {
        UpdateNicknameResponse response = memberService.updateNickname(authMember, request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/user/members/password")
    public ResponseEntity<Void> updatePassword(@Authenticated AuthMember authMember,
                                               @RequestBody UpdatePasswordRequest request) {
        memberService.updatePassword(authMember, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/members/withdraw")
    public ResponseEntity<Void> withdraw(@Authenticated AuthMember authMember) {
        memberService.withdrawalByMember(authMember);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/members/nickname")
    public ResponseEntity<NicknameResponse> findMemberNickname(@Authenticated AuthMember authMember) {
        NicknameResponse response = memberService.findMemberNickname(authMember);
        return ResponseEntity.ok(response);
    }
}
