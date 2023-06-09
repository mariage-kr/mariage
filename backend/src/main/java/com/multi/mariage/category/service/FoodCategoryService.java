package com.multi.mariage.category.service;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.domain.FoodRepository;
import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FoodCategoryService {

    private final FoodRepository foodRepository;

    public FoodCategoryResponse findFoodCategories() {
        List<FoodCategoriesVO> foodValues = getFoodValues();
        return FoodCategoryResponse.from(foodValues);
    }

    private List<FoodCategoriesVO> getFoodValues() {
        return Arrays.stream(FoodCategory.values())
                .map(FoodCategoriesVO::from)
                .toList();
    }

    @Transactional
    public Food findProductWithCategory(FoodCategory foodCategory, Product product) {
        Optional<Food> foodOptional = foodRepository.findByCategoryAndProduct(foodCategory, product);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.setProduct(product);

            return food;
        }

        Food food = new Food(foodCategory);
        food.setProduct(product);

        return foodRepository.save(food);
    }

    public List<Food> findFoodsByProduct(Product product, int size) {
        return foodRepository.findByProductId(product.getId(), size);
    }

    public List<Food> findFoodsOrderByReviewCount(Product product, int size) {
        return foodRepository.orderByReviewCount(product.getId(), size);
    }

    @Transactional
    public void removeByReview(Review review) {
        Food food = review.getFoodCategory();
        if (food == null) {
            return;
        }
        food.getReviews().remove(review);
        if (food.getReviews().isEmpty()) {
            foodRepository.delete(food);
        }
    }
}
