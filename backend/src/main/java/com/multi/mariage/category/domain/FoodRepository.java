package com.multi.mariage.category.domain;

import com.multi.mariage.category.domain.query.FoodRepositoryCustom;
import com.multi.mariage.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long>, FoodRepositoryCustom {
    Optional<Food> findByFoodCategoryAndProduct(FoodCategory foodCategory, Product product);
}
