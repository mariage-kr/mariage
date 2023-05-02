package com.multi.mariage.auth.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReissueRequest {
    private String accessToken;
    private String refreshToken;
}
