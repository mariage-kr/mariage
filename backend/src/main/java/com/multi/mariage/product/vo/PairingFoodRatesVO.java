package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PairingFoodRatesVO {
    private int id; // 음식 id
    //    private String imageUrl;    // 음식 이미지 url
    private String name;    // 음식 이름
    private double rate;    // 음식에 대한 평균평점

    @Builder
    private PairingFoodRatesVO(int id, String name, double rate) {
        this.id = id;
//        this.imageUrl = imageUrl;
        this.name = name;
        this.rate = rate;
    }

    public static PairingFoodRatesVO from(int id, String name, double rate) {
        return PairingFoodRatesVO.builder()
                .id(id)
//                .imageUrl(imageUrl)
                .name(name)
                .rate(rate)
                .build();
    }
}
