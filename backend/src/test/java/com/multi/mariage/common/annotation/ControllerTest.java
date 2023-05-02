package com.multi.mariage.common.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.mariage.global.security.SecurityConfig;
import com.multi.mariage.member.controller.MemberController;
import com.multi.mariage.member.service.MemberService;
import com.multi.mariage.storage.controller.StorageController;
import com.multi.mariage.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureRestDocs
@AutoConfigureMockMvc
@WebMvcTest({
        MemberController.class,
        StorageController.class,
        SecurityConfig.class,
})
@ActiveProfiles("test")
public abstract class ControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @MockBean
    protected MemberService memberService;
    @MockBean
    protected StorageService storageService;
}
