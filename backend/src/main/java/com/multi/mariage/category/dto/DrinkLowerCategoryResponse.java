package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryResponse {
    private List<DrinkLowerCategoryValuesResponse> category;

    public DrinkLowerCategoryResponse(List<DrinkLowerCategoryValuesResponse> category) {
        this.category = category;
    }
}
