package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoriesResponse {
    private String name;
    private String value;
    private List<DrinkLowerCategoriesSubResponse> subCategories;

    @Builder
    public DrinkLowerCategoriesResponse(String name, String value, List<DrinkLowerCategoriesSubResponse> subCategories) {
        this.name = name;
        this.value = value;
        this.subCategories = subCategories;
    }
}
