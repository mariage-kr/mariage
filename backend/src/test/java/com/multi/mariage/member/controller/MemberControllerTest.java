package com.multi.mariage.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.mariage.member.domain.Gender;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Transactional
@SpringBootTest
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("사용자가 회원 가입한다.")
    @Test
    void 사용자가_회원_가입한다() throws Exception {
        MemberSignupRequest memberSignupRequest = MemberSignupRequest.builder()
                .birth(LocalDate.of(1998, 1, 1))
                .email("mariage23@gmail.com")
                .gender(Gender.MAN)
                .name("마리아")
                .nickname("Mariage")
                .password("mariage12!@")
                .build();

        String content = objectMapper.writeValueAsString(memberSignupRequest);

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
                                        PayloadDocumentation.fieldWithPath("birth").description("회원 생년월일"),
                                        PayloadDocumentation.fieldWithPath("gender").description("회원 성별")
                                )
                        )
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}