package com.multi.mariage.product.vo.filter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ProductCountryFilterVO {
    private int countryId;
    private String country;

    @Builder
    public ProductCountryFilterVO(int countryId, String country) {
        this.countryId = countryId;
        this.country = country;
    }
}
