package com.multi.mariage.common.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.mariage.auth.service.AuthService;
import com.multi.mariage.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@AutoConfigureRestDocs
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class ControllerTest {
    protected final String BEARER_PREFIX = "Bearer ";
    protected final String AUTHORIZATION = "Authorization";
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected MemberService memberService;
    @Autowired
    protected AuthService authService;
}
