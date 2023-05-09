package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoriesResponse {

    private String name;
    private String value;

    @Builder
    public DrinkUpperCategoriesResponse(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
