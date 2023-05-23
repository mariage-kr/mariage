package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.PairingFoodCountsVO;
import com.multi.mariage.product.vo.PairingFoodRatesVO;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.vo.ReviewRateVO;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductFindService {
    private final ImageService imageService;
    private final ProductRepository productRepository;
    private final WeatherService weatherService;

    public ProductFindResponse findProducts() {
        List<ProductsVO> productValues = getProductValues();

        return ProductFindResponse.builder()
                .product(productValues)
                .length(productValues.size())
                .build();
    }

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
    }

    public List<ProductMainCardResponse> findWeather(int size) {
        List<Product> products = productRepository.findWeather(size, weatherService.findLatestWeather());

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findWeek(int size) {
        List<Product> products = productRepository.findWeek(size);

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findMonth(int size) {
        List<Product> products = productRepository.findMonth(size);

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findTotal(int size) {
        List<Product> products = productRepository.findTotal(size);

        return products.stream().map(this::toProductMainCard).toList();
    }

    private ProductMainCardResponse toProductMainCard(Product product) {
        List<Review> reviews = product.getReviews();
        Country country = product.getCountry();

        return ProductMainCardResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productImageUrl(imageService.getImageUrl(product.getImage().getName()))
                .reviewCount(reviews.size())
                .reviewRate(getReviewAverageRate(reviews))
                .country(country.getValue())
                .countryImageUrl(imageService.getImageUrl(country.getFlagName()))
                .build();
    }

    private List<ProductsVO> getProductValues() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String imageUrl = imageService.getImageUrl(product.getImage().getName());
                    return ProductsVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
    }

    private double getReviewAverageRate(List<Review> reviews) {
        long totalRate = 0L;
        for (Review review : reviews) {
            totalRate += review.getProductRate();
        }
        return Math.round((double) totalRate / reviews.size());
    }
}
