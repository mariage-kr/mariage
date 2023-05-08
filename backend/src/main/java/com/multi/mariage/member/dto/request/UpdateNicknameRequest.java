package com.multi.mariage.member.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class UpdateNicknameRequest {
    private String nickname;

    public UpdateNicknameRequest(String nickname) {
        this.nickname = nickname;
    }
}
