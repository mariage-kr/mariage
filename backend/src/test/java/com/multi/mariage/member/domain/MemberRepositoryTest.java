package com.multi.mariage.member.domain;

import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.fixture.MemberFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    void setUp() {
        member = memberRepository.save(MemberFixture.MARI.toMember());
    }

    @DisplayName("회원을 저장한다.")
    @Test
    void 회원을_저장한다() {
        Member expected = MemberFixture.SURI.toMember();

        Member actual = memberRepository.save(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("해당 이메일이 이미 존재하는지 확인한다.")
    @Test
    void 해당_이메일이_이미_존재하는지_확인한다() {
        String email = member.getEmail();

        boolean actual = memberRepository.existsByEmail(Email.of(email));

        assertThat(actual).isTrue();
    }
}