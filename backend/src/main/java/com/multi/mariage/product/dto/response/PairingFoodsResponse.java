package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.PairingFoodRatesVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PairingFoodsResponse {
    private Long id;
    private List<PairingFoodRatesVO> foods;

    private PairingFoodsResponse(Product product, List<PairingFoodRatesVO> foods) {
        this.id = product.getId();
        this.foods = foods;
    }

    public static PairingFoodsResponse from(Product product, List<PairingFoodRatesVO> foods) {
        return new PairingFoodsResponse(product, foods);
    }
}
