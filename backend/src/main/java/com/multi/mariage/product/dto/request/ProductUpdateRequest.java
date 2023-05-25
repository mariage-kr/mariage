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
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String info;
    private double level;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private Long imageId;
    private Long newImageId;

    @Builder
    public ProductUpdateRequest(Long id, String name, String info, double level, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, Long imageId, Long newImageId) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.level = level;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.imageId = imageId;
        this.newImageId = newImageId;
    }
}
