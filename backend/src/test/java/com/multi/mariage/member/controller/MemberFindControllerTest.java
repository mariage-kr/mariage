package com.multi.mariage.member.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberFindControllerTest extends ControllerTest {

    private String ACCESS_TOKEN;

    @BeforeEach
    void setUp() {
        saveMember();
        ACCESS_TOKEN = accessToken(MemberFixture.MARI);
    }

    @DisplayName("회원 정보를 조회한다.")
    @Test
    void 회원_정보를_조회한다() throws Exception {
        mockMvc.perform(get("/api/user/members/find")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(
                        document("Member/FindMemberInfo",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("birth").description("회원 생년월일"),
                                        fieldWithPath("email").description("회원 이메일"),
                                        fieldWithPath("imagePath").description("프로필 이미지 경로"),
                                        fieldWithPath("nickname").description("회원 별칭")
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    @DisplayName("회원의 별칭을 조회한다.")
    @Test
    void 회원의_별칭을_조회한다() throws Exception {
        mockMvc.perform(get("/api/user/members/nickname")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(
                        document("Member/FindMemberNickname",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("nickname").description("회원 별칭")
                                )
                        )
                )
                .andExpect(status().isOk());
    }
}