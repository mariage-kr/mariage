package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.member.dto.request.MemberSignupRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum MemberFixture {
    MARI("마리", "mari1234@gmail.com", "qwer1234!@", "마리", LocalDate.of(1990, 1, 1)),
    SURI("수리", "suri1234@gmail.com", "suri23!@", "수리", LocalDate.of(1991, 12, 31));

    private String name;
    private String email;
    private String password;
    private String nickname;
    private LocalDate birth;

    MemberFixture(String name, String email, String password, String nickname, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
    }

    public MemberSignupRequest toSignupRequest() {
        return MemberSignupRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .nickname(nickname)
                .birth(birth)
                .build();
    }

    public String getEmail() {
        return email;
    }
}
