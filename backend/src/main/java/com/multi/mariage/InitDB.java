package com.multi.mariage;

import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class InitDB {

    private final InitMemberService memberService;

    @PostConstruct
    public void init() {
        memberService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberService memberService;

        public void init() {
            MemberSignupRequest request = MemberSignupRequest.builder()
                    .name("마리")
                    .email("mari1234@gmail.com")
                    .birth(LocalDate.now())
                    .password("qwer1234!@")
                    .nickname("마리아주")
                    .build();

            memberService.signup(request);
        }
    }
}
