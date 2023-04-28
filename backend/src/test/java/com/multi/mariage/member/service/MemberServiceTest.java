package com.multi.mariage.member.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import com.multi.mariage.fixture.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService.signup(MemberFixture.MARI.toSignupRequest());
    }

    @DisplayName("회원 가입한다.")
    @Test
    void 회원_가입한다() {
        MemberSignupRequest request = MemberFixture.SURI.toSignupRequest();

        Member actual = memberService.signup(request);

        assertThat(actual).isNotNull();
    }

    @DisplayName("이미 가입된 이메일인 경우 예외를 던진다.")
    @Test
    void 이미_가입된_이메일인_경우_예외를_던진다() {
        MemberSignupRequest request = MemberFixture.MARI.toSignupRequest();

        assertThatThrownBy(() -> memberService.signup(request))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.SIGNUP_INVALID_EMAIL.getMessage());
    }
}