package com.multi.mariage.member.dto.request;

import com.multi.mariage.member.domain.Gender;
import lombok.AccessLevel;
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
}
