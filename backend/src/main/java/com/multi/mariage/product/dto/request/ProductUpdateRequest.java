package com.multi.mariage.product.dto.request;

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
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String info;
    private double level;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private Long imageId;
    private Long newImageId;

    private ProductUpdateRequest(Product product, Long imageId, Long newImageId) {
        this.id = product.getId();
        this.name = String.valueOf(product.getName());
        this.level = product.getLevel().getValue();
        this.info = String.valueOf(product.getInfo());
        this.country = product.getCountry();
        this.upperCategory = product.getUpperCategory();
        this.lowerCategory = product.getLowerCategory();
        this.imageId = imageId;
        this.newImageId = newImageId;
    }

    public static ProductUpdateRequest from(Product product, Long imageId, Long newImageId) {
        return new ProductUpdateRequest(product, imageId, newImageId);
    }
}
