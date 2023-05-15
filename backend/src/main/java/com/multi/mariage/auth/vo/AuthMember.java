package com.multi.mariage.auth.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuthMember {
    private Long id;

    public AuthMember(Long id) {
        this.id = id;
    }
}
