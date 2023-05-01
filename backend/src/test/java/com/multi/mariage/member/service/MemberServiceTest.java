package com.multi.mariage.member.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberServiceTest extends ServiceTest {

    @Autowired
    private MemberService memberService;

    private Member member;

    @BeforeEach
    void setUp() {
        member = memberService.signup(MemberFixture.MARI.toSignupRequest());
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

    @DisplayName("회원 탈퇴한다.")
    @Test
    void 회원_탈퇴한다() {
        memberService.withdrawal(member);

        assertThat(member.getDeleted()).isTrue();
    }

    @DisplayName("이미 탈퇴한 회원이면 예외를 던진다.")
    @Test
    void 이미_탈퇴한_회원이면_예외를_던진다() {
        memberService.withdrawal(member);

        assertThatThrownBy(() -> memberService.withdrawal(member))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.MEMBER_IS_ALREADY_WITHDRAWAL.getMessage());
    }
}