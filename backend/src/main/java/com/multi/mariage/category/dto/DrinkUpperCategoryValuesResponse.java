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
    private List<DrinkUpperCategoriesResponse> categories;

    @Builder
    public DrinkUpperCategoryValuesResponse(String region, List<DrinkUpperCategoriesResponse> categories) {
        this.region = region;
        this.categories = categories;
    }
}
