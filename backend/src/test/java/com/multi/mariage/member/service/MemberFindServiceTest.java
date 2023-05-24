package com.multi.mariage.member.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.dto.response.MyInfoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberFindServiceTest extends ServiceTest {
    @Value("${storagePath}")
    private String STORAGE_PATH;

    private Member member;

    @BeforeEach
    void setUp() {
        member = signup(MemberFixture.MARI);
    }

    @DisplayName("회원 정보를 조회한다.")
    @Test
    void 회원_정보를_조회한다() {
        AuthMember authMember = convertMember(member);

        MyInfoResponse actual = memberFindService.findMemberProfile(authMember);

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getBirth()).isEqualTo(member.getBirth()),
                () -> assertThat(actual.getEmail()).isEqualTo(member.getEmail()),
                () -> assertThat(actual.getNickname()).isEqualTo(member.getNickname())
        );
    }

    @DisplayName("회원의 프로필 사진이 존재하지 않으면 기본 사진을 가져온다.")
    @Test
    void 회원의_프로필_사진이_존재하지_않으면_기본_사진을_가져온다() {
        AuthMember authMember = convertMember(member);

        MyInfoResponse actual = memberFindService.findMemberProfile(authMember);

        assertThat(actual.getImagePath()).isEqualTo(STORAGE_PATH + "profile.png");
        System.out.println(actual.getImagePath());
    }

    @DisplayName("회원의 별칭을 조회한다.")
    @Test
    void 회원의_별칭을_조회한다() {
        AuthMember authMember = convertMember(member);
        String expected = MemberFixture.MARI.toSignupRequest().getNickname();

        String actual = memberFindService.findMemberInfo(authMember).getNickname();

        assertThat(actual).isEqualTo(expected);
    }

    AuthMember convertMember(Member member) {
        return new AuthMember(member.getId());
    }
}
