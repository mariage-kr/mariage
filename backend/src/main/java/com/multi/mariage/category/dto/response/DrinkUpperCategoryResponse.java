package com.multi.mariage.category.dto.response;

import com.multi.mariage.category.vo.DrinkUpperCategoryValuesVo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryResponse {
    private List<DrinkUpperCategoryValuesVo> category;

    public DrinkUpperCategoryResponse(List<DrinkUpperCategoryValuesVo> category) {
        this.category = category;
    }
}
