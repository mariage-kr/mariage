package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryResponse {
    private List<String> category;

    @Builder
    public DrinkUpperCategoryResponse(List<String> category) {
        this.category = category;
    }
}
