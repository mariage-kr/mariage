package com.multi.mariage.member.domain;

import com.multi.mariage.common.fixture.MemberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @DisplayName("회원이 탈퇴한다.")
    @Test
    void 회원이_탈퇴한다() {
        // given
        Member member = MemberFixture.MARI.toMember();

        // when
        member.changeDelete();

        // then
        assertThat(member.getDeleted()).isTrue();
    }
}