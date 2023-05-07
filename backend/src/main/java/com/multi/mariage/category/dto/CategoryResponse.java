package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CategoryResponse {

    private List<DrinkUpperCategoryResponse> category;

    @Builder
    public CategoryResponse(List<DrinkUpperCategoryResponse> category) {
        this.category = category;
    }
}
