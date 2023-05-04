package com.multi.mariage.member.dto.response;

import com.multi.mariage.member.domain.Member;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class UpdateNicknameResponse {
    private String nickname;

    private UpdateNicknameResponse(String nickname) {
        this.nickname = nickname;
    }

    public static UpdateNicknameResponse from(Member member) {
        return new UpdateNicknameResponse(member.getNickname());
    }
}
