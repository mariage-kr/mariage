package com.multi.mariage.auth.dto.request;

import com.multi.mariage.auth.dto.response.TokenResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ReissueRequest {
    private String accessToken;
    private String refreshToken;

    private ReissueRequest(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public static ReissueRequest from(TokenResponse token) {
        return new ReissueRequest(token.getAccessToken(), token.getRefreshToken());
    }
}
