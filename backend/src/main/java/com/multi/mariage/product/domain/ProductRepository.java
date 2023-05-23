package com.multi.mariage.product.domain;

import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.domain.query.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    boolean existsByName(Name name);

    @Query("select avg(coalesce(r.foodRate, 0)) " +
            "from Product p " +
            "left join p.reviews r " +
            "where p.id = :productId")
    Double getTotalFoodRateAverageByProductId(@Param("productId") Long productId);

    @Query("SELECT r.foodCategory, AVG(r.foodRate) " +
            "FROM Review r " +
            "GROUP BY r.foodCategory")
    List<Object[]> getAverageFoodRates();
}
