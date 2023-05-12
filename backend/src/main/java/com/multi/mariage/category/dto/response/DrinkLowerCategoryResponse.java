package com.multi.mariage.category.dto.response;

import com.multi.mariage.category.vo.drink_lower.DrinkLowerCategoryValuesVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryResponse {
    private List<DrinkLowerCategoryValuesVO> category;

    public DrinkLowerCategoryResponse(List<DrinkLowerCategoryValuesVO> category) {
        this.category = category;
    }
}
