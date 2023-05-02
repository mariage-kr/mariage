package com.multi.mariage.auth.service;

import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.support.TokenProvider;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;

import static com.multi.mariage.common.fixture.MemberFixture.MARI;
import static org.assertj.core.api.Assertions.*;

class AuthServiceTest extends ServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TokenProvider tokenProvider;

    @BeforeEach
    void setUp() {
        signupMember();
    }

    @DisplayName("회원이 로그인한다.")
    @Test
    void 회원이_로그인한다() {
        TokenResponse response = authService.login(MARI.toLoginRequest());
        assertThat(response).isNotNull();
    }

    @DisplayName("로그인정보가 일치하지 않으면 예외를 던진다.")
    @Test
    void 로그인정보가_일치하지_않으면_예외를_던진다() {
        LoginRequest request = convertWrongRequest(MARI.toLoginRequest());

        assertThatThrownBy(() -> authService.login(request))
                .isInstanceOf(BadCredentialsException.class);
    }

    @DisplayName("회원이 로그아웃한다.")
    @Test
    void 회원이_로그아웃한다() {
        TokenResponse response = authService.login(MARI.toLoginRequest());
        AuthMember authMember = convertAuthMemberFromToken(response.getAccessToken());

        assertThatCode(() -> authService.logout(authMember))
                .doesNotThrowAnyException();
    }

    void signupMember() {
        memberService.signup(MARI.toSignupRequest());
    }

    LoginRequest convertWrongRequest(LoginRequest request) {
        return LoginRequest.builder()
                .email(request.getEmail())
                .password(request.getPassword() + "0")
                .build();
    }

    AuthMember convertAuthMemberFromToken(String accessToken) {
        Long memberId = Long.valueOf(tokenProvider.getPayload(accessToken));
        return new AuthMember(memberId);
    }
}