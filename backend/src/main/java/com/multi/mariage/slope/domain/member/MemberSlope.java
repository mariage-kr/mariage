package com.multi.mariage.slope.domain.member;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MemberSlope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "this_product_id")
    private Product thisProduct;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_product_id")
    private Product otherProduct;

    @Column(name = "rate_deviation")
    private double deviation = 0D;

    @Column(name = "member_size")
    private Long size = 0L;

    @Builder
    public MemberSlope(Member member, Product thisProduct, Product otherProduct) {
        this.member = member;
        this.thisProduct = thisProduct;
        this.otherProduct = otherProduct;
    }

    public void changeDeviationByReview(int score) {
        double totalScore = deviation * size;
        size++;
        deviation = (totalScore + score) / size;
    }
}
