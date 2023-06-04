package com.multi.mariage.slope.domain.product;

import com.multi.mariage.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProductSlope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "this_product_id")
    private Product thisProduct;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_product_id")
    private Product targetProduct;

    @Column(name = "product_deviation")
    private double deviation = 0D;

    @Column(name = "product_review_member_size")
    private Long size = 0L;

    @Builder
    public ProductSlope(Product thisProduct, Product targetProduct) {
        this.thisProduct = thisProduct;
        this.targetProduct = targetProduct;
    }

    public void changeDeviation(double deviation, Long size) {
        this.deviation = deviation;
        this.size = size;
    }
}
