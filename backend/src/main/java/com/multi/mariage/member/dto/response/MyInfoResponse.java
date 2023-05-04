package com.multi.mariage.member.dto.response;

import com.multi.mariage.member.domain.Member;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MyInfoResponse {
    private LocalDate birth;
    private String email;
    private String imagePath;
    private String nickname;

    public MyInfoResponse(LocalDate birth, String email, String imagePath, String nickname) {
        this.birth = birth;
        this.email = email;
        this.imagePath = imagePath;
        this.nickname = nickname;
    }

    public static MyInfoResponse from(Member member, String imagePath) {
        return new MyInfoResponse(member.getBirth(), member.getEmail(), imagePath, member.getNickname());
    }
}
