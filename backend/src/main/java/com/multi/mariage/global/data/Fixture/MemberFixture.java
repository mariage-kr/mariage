package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.member.dto.request.MemberSignupRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@SuppressWarnings("all")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum MemberFixture {
    MARI("마리", "mari1234@gmail.com", "qwer1234!@", "마리", LocalDate.of(1990, 1, 1)),
    SURI("수리", "suri1234@gmail.com", "suri23!@", "수리", LocalDate.of(1991, 12,31)),
    HARI("하리", "hari1234@gmail.com", "hari23!@", "하리", LocalDate.of(1992, 2, 20)),
    DORI("도리", "dori1234@gmail.com", "dori23!@", "도리", LocalDate.of(1993, 4, 15)),
    SEI("세이", "sei12345@gmail.com", "sei123!@", "세이", LocalDate.of(1994, 5,15)),
    RIMI("리미", "rimi1234@gmail.com", "rimi23!@", "리미", LocalDate.of(1995, 3,3)),
    JINEE("지니", "jinee1234@gmail.com", "jinee23!@", "지니", LocalDate.of(1996, 7,27)),
    SLUG("민달팽이", "slug1234@gmail.com", "slug23!@", "민달팽이", LocalDate.of(1997, 8,10)),
    MINI("미니", "mini1234@gmail.com", "mini23!@", "미니", LocalDate.of(1998, 9,11)),;

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
