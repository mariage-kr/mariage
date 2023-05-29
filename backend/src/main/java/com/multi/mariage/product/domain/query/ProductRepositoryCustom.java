package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.condition.RecommendCond;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.weather.domain.Weather;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchProductByName(String name);

    List<Product> findRecommendProductsByWeather(int size, Weather latestWeather);

    List<Product> findRecommendProductsByDate(RecommendCond cond);

    List<Product> findProductsByFilter(ProductFindByFilterRequest cond);

    Long countProductWithFilter(ProductFindByFilterRequest cond);

    List<Product> findBySearch(String search);
}
