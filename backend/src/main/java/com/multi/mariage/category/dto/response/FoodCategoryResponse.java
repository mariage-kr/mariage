package com.multi.mariage.category.dto.response;

import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCategoryResponse {
    private List<FoodCategoriesVO> category;
    private int length;

    @Builder
    private FoodCategoryResponse(List<FoodCategoriesVO> category, int length) {
        this.category = category;
        this.length = length;
    }

    public static FoodCategoryResponse from(List<FoodCategoriesVO> category) {
        return FoodCategoryResponse.builder()
                .category(category)
                .length(category.size())
                .build();
    }

}
