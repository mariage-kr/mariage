package com.multi.mariage.product.vo.filter;

import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductCountryFilterVO {
    private int countryId;
    private String country;

    @Builder
    private ProductCountryFilterVO(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }

    public static ProductCountryFilterVO from(Product product) {
        Country country = product.getCountry();
        return ProductCountryFilterVO.builder()
                .country(country.getValue())
                .countryId(country.getId())
                .build();
    }
}
