package com.multi.mariage.category.domain.query;

import com.multi.mariage.category.domain.Food;

import java.util.List;

public interface FoodRepositoryCustom {

    List<Food> findByProductId(Long productId, int size);

    List<Food> orderByReviewCount(Long productId, int size);
}
