package com.multi.mariage.category.dto.response;

import com.multi.mariage.category.vo.DrinkLowerCategoryValuesVo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryResponse {
    private List<DrinkLowerCategoryValuesVo> category;

    public DrinkLowerCategoryResponse(List<DrinkLowerCategoryValuesVo> category) {
        this.category = category;
    }
}
