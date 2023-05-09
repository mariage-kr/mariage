package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryValuesResponse {

    private String region;
    private String regionValue;
    private List<DrinkLowerCategoriesResponse> categories;

    @Builder
    public DrinkLowerCategoryValuesResponse(String region, String regionValue, List<DrinkLowerCategoriesResponse> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }
}
