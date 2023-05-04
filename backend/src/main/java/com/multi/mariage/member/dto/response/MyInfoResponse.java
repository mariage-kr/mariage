package com.multi.mariage.member.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MyInfoResponse {
    private String email;
    private String nickname;
    private String imagePath;
}
