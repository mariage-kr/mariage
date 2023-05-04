package com.multi.mariage.member.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class UpdateImageResponse {
    private String imagePath;

    public UpdateImageResponse(String imagePath) {
        this.imagePath = imagePath;
    }
}
