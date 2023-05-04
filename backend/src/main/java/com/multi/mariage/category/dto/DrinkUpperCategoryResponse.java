package com.multi.mariage.category.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DrinkUpperCategoryResponse {
        private List<String> category;

        public DrinkUpperCategoryResponse(List<String> category) {
                this.category = category;
        }
}
