package com.multi.mariage.member.controller;

import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.request.UpdateNicknameRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberControllerTest extends ControllerTest {

    private static final MockMultipartFile IMAGE = ImageFixture.JPEG_IMAGE.toMultipartFile();
    private String ACCESS_TOKEN;

    @BeforeEach
    void setUp() {
        saveMember();
        ACCESS_TOKEN = accessToken();
    }

    @DisplayName("사용자가 회원 가입한다.")
    @Test
    void 사용자가_회원_가입한다() throws Exception {
        String content = objectMapper.writeValueAsString(MemberFixture.SURI.toSignupRequest());

        mockMvc.perform(post("/api/members/signup")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andDo(
                        document("Member: Signup",
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
        mockMvc.perform(delete("/api/user/members/withdraw")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(document("Member: Withdraw"))
                .andExpect(status().isOk());
    }

    @DisplayName("사용자의 프로필 이미지를 수정한다.")
    @Test
    void 사용자의_프로필_이미지를_수정한다() throws Exception {
        mockMvc.perform(multipart("/api/user/members/update/image")
                        .file(IMAGE)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(document("Member: UpdateImage",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("imagePath").description("수정한 이미지 파일의 경로")
                                )
                        )
                )
                .andExpect(status().isCreated());
    }

    @DisplayName("사용자의 프로필 이미지를 삭제한다.")
    @Test
    void 사용자의_프로필_이미지를_삭제한다() throws Exception {
        mockMvc.perform(multipart("/api/user/members/update/image")
                .file(IMAGE)
                .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN));

        mockMvc.perform(patch("/api/user/members/remove/image")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(document("Member: RemoveImage"))
                .andExpect(status().isOk());
    }

    @DisplayName("사용자의 별칭을 수정한다.")
    @Test
    void 사용자의_별칭을_수정한다() throws Exception {
        UpdateNicknameRequest request = new UpdateNicknameRequest("마리아주");
        String content = objectMapper.writeValueAsString(request);

        mockMvc.perform(patch("/api/user/members/update/nickname")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(
                        document("Member: UpdateNickname",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("nickname").description("변경할 별칭")
                                ),
                                responseFields(
                                        fieldWithPath("nickname").description("변경된 별칭")
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    void saveMember() {
        MemberSignupRequest request = MemberFixture.MARI.toSignupRequest();
        memberService.signup(request);
    }

    String accessToken() {
        LoginRequest request = MemberFixture.MARI.toLoginRequest();
        return authService.login(request).getAccessToken();
    }
}