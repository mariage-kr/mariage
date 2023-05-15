package com.multi.mariage.product.dto.request;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import lombok.AccessLevel;
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

}
