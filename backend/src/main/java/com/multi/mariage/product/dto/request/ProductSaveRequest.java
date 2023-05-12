package com.multi.mariage.product.dto.request;

import com.multi.mariage.storage.domain.Image;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSaveRequest {

    private String name;    // 제품 이름:
    private double level;   // 도수
    private String info;    // 설명: 150자 제한
    private String country; // 국가

    private String upperCategory;   // 상위
    private String lowerCategory;   // 하위
    private Image image;
    private Long imageId;
}
