package com.multi.mariage.product.dto.request;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSaveRequest {

    private String name;
    private double level;
    private String info;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private Long imageId;

    @Builder
    private ProductSaveRequest(String name, double level, String info, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, Long imageId) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.imageId = imageId;
    }
}
