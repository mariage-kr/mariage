package com.multi.mariage.member.service;

import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.dto.request.UpdateNicknameRequest;
import com.multi.mariage.member.dto.response.UpdateImageResponse;
import com.multi.mariage.member.dto.response.UpdateNicknameResponse;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class MemberServiceTest extends ServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

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
        memberService.withdrawalByMember(new AuthMember(member.getId()));

        Optional<Member> actual = memberRepository.findById(member.getId());

        assertThat(actual).isEmpty();
    }

    @DisplayName("프로필 이미지를 수정한다.")
    @Test
    void 프로필_이미지를_수정한다() {
        UpdateImageResponse actual = updateImage();

        assertThat(actual).isNotNull();
    }

    @DisplayName("프로필 이미지를 삭제한다.")
    @Test
    void 프로필_이미지를_삭제한다() {
        updateImage();

        assertAll(
                () -> assertThatCode(() -> memberService.removeImage(convertMember(member)))
                        .doesNotThrowAnyException(),
                () -> assertThat(member.getImage()).isNull()
        );
    }

    @DisplayName("별칭을 수정한다.")
    @ParameterizedTest
    @ValueSource(strings = {"마리아주", "mariage"})
    void 별칭을_수정한다(String nickname) {
        AuthMember authMember = convertMember(member);
        UpdateNicknameRequest request = new UpdateNicknameRequest(nickname);

        UpdateNicknameResponse actual = memberService.updateNickname(authMember, request);

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getNickname()).isEqualTo(nickname)
        );
    }

    AuthMember convertMember(Member member) {
        return new AuthMember(member.getId());
    }

    UpdateImageResponse updateImage() {
        MockMultipartFile file = ImageFixture.JPEG_IMAGE.toMultipartFile();
        AuthMember authMember = convertMember(member);

        return memberService.updateImage(authMember, file);
    }
}