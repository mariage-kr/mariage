package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PairingFoodsVO {
    private int id; // 음식 id
    private String imageUrl;    // 음식 이미지 url
    private String name;    // 음식 이름
    private double rate;    // 음식에 대한 평균평점

    @Builder
    private PairingFoodsVO(int id, String imageUrl, String name, double rate) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.rate = rate;
    }

    public static PairingFoodsVO from(int id, String imageUrl, String name, double rate) {
        return PairingFoodsVO.builder()
                .id(id)
                .imageUrl(imageUrl)
                .name(name)
                .rate(rate)
                .build();
    }
}
