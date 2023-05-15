package com.multi.mariage.product.dto.response;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductInfoResponse {
    private String name;
    private String info;
    private double level;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private Long imageId;
    private String imageUrl;

    private ProductInfoResponse(Product product ,String imageUrl) {
        this.name = product.getName();
        this.info = product.getInfo();
        this.level = product.getLevel();
        this.country = product.getCountry();
        this.upperCategory = product.getUpperCategory();
        this.lowerCategory = product.getLowerCategory();
        this.imageId = product.getImage().getId();
        this.imageUrl = imageUrl;
    }

    public static ProductInfoResponse from(Product product, String imageUrl) {
        return new ProductInfoResponse(product, imageUrl);
    }
}
