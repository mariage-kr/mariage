package com.multi.mariage.member.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberInfoResponse {
    private Long id;

    private String nickname;

    public MemberInfoResponse(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
