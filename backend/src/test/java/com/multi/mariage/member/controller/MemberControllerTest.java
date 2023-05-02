package com.multi.mariage.member.controller;

import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberControllerTest extends ControllerTest {

    @DisplayName("사용자가 회원 가입한다.")
    @Test
    void 사용자가_회원_가입한다() throws Exception {
        String content = objectMapper.writeValueAsString(MemberFixture.MARI.toSignupRequest());

        mockMvc.perform(post("/api/members/signup")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andDo(
                        document("Signup",
                                preprocessRequest(prettyPrint()),
                                requestFields(
                                        fieldWithPath("name").description("회원 이름"),
                                        fieldWithPath("email").description("회원 이메일"),
                                        fieldWithPath("password").description("회원 비밀번호"),
                                        fieldWithPath("nickname").description("회원 닉네임"),
                                        fieldWithPath("birth").description("회원 생년월일")
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    @DisplayName("사용자가 탈퇴한다.")
    @Test
    void 사용자가_탈퇴한다() throws Exception {
        saveMember();
        String accessToken = accessToken();

        mockMvc.perform(delete("/api/user/members/withdraw")
                        .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andDo(document("Withdraw"))
                .andExpect(status().isOk());
    }

    void saveMember() {
        MemberSignupRequest request = MemberFixture.SURI.toSignupRequest();
        memberService.signup(request);
    }

    String accessToken() {
        LoginRequest request = MemberFixture.SURI.toLoginRequest();
        return authService.login(request).getAccessToken();
    }
}