package com.multi.mariage.auth.domain;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 7)
public class RefreshToken {
    @Id
    private Long id;
    private String value;

    @Builder
    public RefreshToken(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
