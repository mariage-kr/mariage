package com.multi.mariage.fixture;

import com.multi.mariage.member.domain.Gender;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import groovy.transform.builder.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public enum MemberFixture {
    MARI("마리", "mari2023@gmail.com", "mari23!@", "마리", LocalDate.of(1990, 1, 1), Gender.WOMAN),
    SURI("수리","suri2023@gmail.com", "suri23!@", "수리", LocalDate.of(1991, 12, 31), Gender.MAN);

    private final String name;
    private final String email;
    private final String password;
    private final String nickname;
    private final LocalDate birth;
    private final Gender gender;

    @Builder
    MemberFixture(String name, String email, String password, String nickname, LocalDate birth, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
    }

    public Member toMember() {
        return Member.builder()
                .name(Name.of(name))
                .email(Email.of(email))
                .password(Password.encrypt(password, new BCryptPasswordEncoder()))
                .nickname(Nickname.of(nickname))
                .birth(birth)
                .gender(gender)
                .build();
    }

    public MemberSignupRequest toSignupRequest() {
        return MemberSignupRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .nickname(nickname)
                .birth(birth)
                .gender(gender)
                .build();
    }
}
