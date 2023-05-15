package com.multi.mariage.auth.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.auth.dto.request.ReissueRequest;
import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        TokenResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/user/auth/logout")
    public ResponseEntity<Void> logout(@Authenticated AuthMember authMember) {
        authService.logout(authMember);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/auth/reissue")
    public ResponseEntity<TokenResponse> reissue(@RequestBody ReissueRequest request) {
        TokenResponse response = authService.reissue(request);
        return ResponseEntity.ok(response);
    }
}
