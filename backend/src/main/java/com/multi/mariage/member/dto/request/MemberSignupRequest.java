package com.multi.mariage.member.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberSignupRequest {
    private String name;
    private String email;
    private String password;
    private String nickname;
    private LocalDate birth;

    @Builder
    public MemberSignupRequest(String name, String email, String password, String nickname, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
    }
}
