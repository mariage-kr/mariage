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

    public MyInfoResponse(LocalDate birth, String email, String filePath, String nickname) {
        this.birth = birth;
        this.email = email;
        this.imagePath = filePath;
        this.nickname = nickname;
    }

    public static MyInfoResponse from(Member member, String filePath) {
        return new MyInfoResponse(member.getBirth(), member.getEmail(), filePath, member.getNickname());
    }
}
