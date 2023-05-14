package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;

import java.util.concurrent.atomic.AtomicLong;

public enum ProductFixture {

    PRODUCT_MAKGEOLLI1("느린마을 막걸리", 20, "쌀로 만든 술입니다.", Country.KOREA, DrinkUpperCategory.LOCAL_TRADITIONAL, DrinkLowerCategory.MAKGEOLLI),
    PRODUCT_SOJU1("참이슬", 16.5, "대나무 숯으로 4번 걸러 더 깨끗한 목넘김과 이슬형태의 곡선 라벨로 더욱 트렌디해진 참이슬 fresh 입니다.", Country.KOREA, DrinkUpperCategory.LOCAL_SOJU, DrinkLowerCategory.NORMAL_SOJU);
    private String name;
    private double level;
    private String info;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;

    ProductFixture(String name, double level, String info, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
    }

    public ProductSaveRequest toSaveRequest() {
        return ProductSaveRequest.builder()
                .name(name)
                .level(level)
                .info(info)
                .country(country)
                .upperCategory(upperCategory)
                .lowerCategory(lowerCategory)
                .build();
    }

    public ProductUpdateRequest toUpdateRequest(Product product, Long imageId, Long newImageId) {
        return ProductUpdateRequest.from(product, imageId, newImageId);
    }
}
