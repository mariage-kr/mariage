package com.multi.mariage.member.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class MemberControllerTest extends ControllerTest {

    @DisplayName("사용자가 회원 가입한다.")
    @Test
    void 사용자가_회원_가입한다() throws Exception {
        String content = objectMapper.writeValueAsString(MemberFixture.MARI.toSignupRequest());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/signup")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andDo(
                        MockMvcRestDocumentation.document("Signup",
                                Preprocessors.preprocessRequest(Preprocessors.prettyPrint()),
                                Preprocessors.preprocessResponse(Preprocessors.prettyPrint()),
                                PayloadDocumentation.requestFields(
                                        PayloadDocumentation.fieldWithPath("name").description("회원 이름"),
                                        PayloadDocumentation.fieldWithPath("email").description("회원 이메일"),
                                        PayloadDocumentation.fieldWithPath("password").description("회원 비밀번호"),
                                        PayloadDocumentation.fieldWithPath("nickname").description("회원 닉네임"),
                                        PayloadDocumentation.fieldWithPath("birth").description("회원 생년월일")
                                )
                        )
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}