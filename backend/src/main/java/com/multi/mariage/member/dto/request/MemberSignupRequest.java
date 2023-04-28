package com.multi.mariage.member.dto.request;

import com.multi.mariage.member.domain.Gender;
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
    private Gender gender;

    @Builder
    public MemberSignupRequest(String name, String email, String password, String nickname, LocalDate birth, Gender gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
    }
}
