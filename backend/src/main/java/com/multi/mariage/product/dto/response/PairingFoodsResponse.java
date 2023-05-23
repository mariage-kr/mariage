package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.PairingFoodsVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PairingFoodsResponse {
    private Long id;
    private List<PairingFoodsVO> foods;

    private PairingFoodsResponse(Product product, List<PairingFoodsVO> foods) {
        this.id = product.getId();
        this.foods = foods;
    }

    public static PairingFoodsResponse from(Product product, List<PairingFoodsVO> foods) {
        return new PairingFoodsResponse(product, foods);
    }
}
