package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.vo.ProductDetailVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductFindResponse {
    private List<ProductDetailVO> product;
    private int length;

    @Builder
    private ProductFindResponse(List<ProductDetailVO> product, int length) {
        this.product = product;
        this.length = length;
    }

    public static ProductFindResponse from(List<ProductDetailVO> product) {
        return ProductFindResponse.builder()
                .product(product)
                .length(product.size())
                .build();
    }
}
