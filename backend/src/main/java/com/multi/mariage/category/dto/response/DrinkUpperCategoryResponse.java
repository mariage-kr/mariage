package com.multi.mariage.category.dto.response;

import com.multi.mariage.category.vo.drink_upper.DrinkUpperCategoryValuesVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryResponse {
    private List<DrinkUpperCategoryValuesVO> category;

    public DrinkUpperCategoryResponse(List<DrinkUpperCategoryValuesVO> category) {
        this.category = category;
    }
}
