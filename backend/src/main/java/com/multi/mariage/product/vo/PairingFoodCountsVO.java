package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PairingFoodCountsVO {
    private int id; // 음식 id
    //    private String imageUrl;    // 음식 이미지 url
    private String name;    // 음식 이름
    private int count;      // 리뷰 개수

    private PairingFoodCountsVO(int id, String name, int count) {
        this.id = id;
//        this.imageUrl = imageUrl;
        this.name = name;
        this.count = count;
    }

    public static PairingFoodCountsVO from(int id, String name, int count) {
        return new PairingFoodCountsVO(id, name, count);
    }
}
