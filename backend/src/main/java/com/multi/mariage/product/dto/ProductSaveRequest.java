package com.multi.mariage.product.dto;

import com.multi.mariage.category.domain.LowerCategory;
import com.multi.mariage.category.domain.UpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.storage.domain.Image;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSaveRequest {

    private String name;
    private double level;
    private String info;
    private Country country;
    private Long imageId;
    private UpperCategory upperCategory;
    private LowerCategory lowerCategory;

}
