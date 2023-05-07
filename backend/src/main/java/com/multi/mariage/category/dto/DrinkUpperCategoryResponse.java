package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryResponse {

    private String region;
    private List<CategoriesResponse> categories;

    @Builder
    public DrinkUpperCategoryResponse(String region, List<CategoriesResponse> categories) {
        this.region = region;
        this.categories = categories;
    }
}
