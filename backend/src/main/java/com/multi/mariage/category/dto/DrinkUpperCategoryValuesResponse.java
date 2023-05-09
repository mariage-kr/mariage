package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryValuesResponse {

    private String region;
    private String regionValue;
    private List<DrinkUpperCategoriesResponse> categories;

    @Builder
    public DrinkUpperCategoryValuesResponse(String region, String regionValue, List<DrinkUpperCategoriesResponse> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }
}
