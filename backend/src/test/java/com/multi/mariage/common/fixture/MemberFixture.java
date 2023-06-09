package com.multi.mariage.common.fixture;

import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum MemberFixture {
    MARI("마리", "mari2023@gmail.com", "mari23!@", "마리", LocalDate.of(1990, 1, 1)),
    SURI("수리", "suri2023@gmail.com", "suri23!@", "수리", LocalDate.of(1991, 12, 31)),
    HARI("하리", "hari2023@gmail.com", "hari23!@", "하리", LocalDate.of(1992, 9, 16)),
    DORI("도리", "dori2023@gmail.com", "dori23!@", "도리", LocalDate.of(1997, 3, 3))
    ;

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

    public Member toMember() {
        return Member.builder()
                .name(Name.of(name))
                .email(Email.of(email))
                .password(Password.encrypt(password, new BCryptPasswordEncoder()))
                .nickname(Nickname.of(nickname))
                .birth(birth)
                .build();
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

    public LoginRequest toLoginRequest() {
        return LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
    }
}
