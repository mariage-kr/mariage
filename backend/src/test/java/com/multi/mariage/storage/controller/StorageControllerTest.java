package com.multi.mariage.storage.controller;

import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.partWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParts;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StorageControllerTest extends ControllerTest {

    private static final MockMultipartFile IMAGE = ImageFixture.JPEG_IMAGE.toMultipartFile();

    @DisplayName("이미지를 저장한다.")
    @Test
    void 이미지를_저장한다() throws Exception {
        saveMember();
        String accessToken = accessToken();

        mockMvc.perform(multipart("/api/user/image")
                        .file(IMAGE)
                        .header("Authorization", "Bearer " + accessToken)
                )
                .andDo(print())
                .andDo(
                        document("Storage/Save",
                                preprocessResponse(prettyPrint()),
                                requestParts(
                                        partWithName("file").description("업로드를 원하는 이미지")),
                                responseFields(
                                        fieldWithPath("imageId").description("이미지 식별자")
                                )
                        )
                )
                .andExpect(status().isCreated());
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