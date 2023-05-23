package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.RecommendCond;
import com.multi.mariage.weather.domain.Weather;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchProductByName(String name);

    List<Product> findWeather(int size, Weather latestWeather);

    List<Product> findDate(RecommendCond cond);

}
