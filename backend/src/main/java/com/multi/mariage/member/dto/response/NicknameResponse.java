package com.multi.mariage.member.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NicknameResponse {

    private String nickname;

    public NicknameResponse(String nickname) {
        this.nickname = nickname;
    }
}
