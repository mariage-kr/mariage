package com.multi.mariage.product.dto;

import com.multi.mariage.country.domain.Country;
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
//    private UpperCategory upperCategory;
//    private LowerCategory lowerCategory;

}
