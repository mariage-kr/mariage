package com.multi.mariage.auth.controller;

import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.service.AuthService;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.multi.mariage.common.fixture.MemberFixture.MARI;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthControllerTest extends ControllerTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        signupMember();
    }

    @DisplayName("회원이 로그인한다.")
    @Test
    void 회원이_로그인한다() throws Exception {
        String content = objectMapper.writeValueAsString(MARI.toLoginRequest());

        mockMvc.perform(post("/api/auth/login")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andDo(
                        document("Login",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("email").description("회원 이메일"),
                                        fieldWithPath("password").description("회원 비밀번호")
                                ),
                                responseFields(
                                        fieldWithPath("grantType").description("부여 유형"),
                                        fieldWithPath("accessToken").description("엑세스 토큰"),
                                        fieldWithPath("refreshToken").description("재발급 토큰"),
                                        fieldWithPath("accessTokenExpiresIn").description("엑세스 토큰 만료일")
                                )
                        ))
                .andExpect(status().isOk());
    }

    @DisplayName("회원이 로그아웃한다.")
    @Test
    void 회원이_로그아웃한다() throws Exception {
        TokenResponse token = authService.login(MARI.toLoginRequest());

        mockMvc.perform(delete("/api/user/auth/logout")
                        .header(AUTHORIZATION, BEARER_PREFIX + token.getAccessToken()))
                .andDo(document("Logout"))
                .andExpect(status().isOk());
    }

    void signupMember() {
        memberService.signup(MARI.toSignupRequest());
    }
}