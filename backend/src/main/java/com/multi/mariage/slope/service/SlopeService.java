package com.multi.mariage.slope.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.slope.domain.member.MemberSlope;
import com.multi.mariage.slope.domain.member.MemberSlopeRepository;
import com.multi.mariage.slope.domain.product.ProductSlope;
import com.multi.mariage.slope.domain.product.ProductSlopeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SlopeService {
    private final MemberSlopeRepository memberSlopeRepository;
    private final ProductSlopeRepository productSlopeRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    /**
     * 유저가 리뷰를 작성 시 주류 선호도 편차 데이터를 업데이트 한다.
     *
     * @param member      해당 유저
     * @param thisReview  새로 작성한 리뷰
     * @param thisProduct 리뷰를 작성한 제품
     */
    @Transactional
    public void updateMemberSlope(Member member, Review thisReview, Product thisProduct) {
        /* 해당 유저가 작성한 제품 리뷰중 현재 제품과 다른 제품들 조회 */
        List<Review> memberReviews = reviewRepository.findAllByMemberId(member.getId(), thisProduct.getId());

        for (Review otherReview : memberReviews) {
            Product otherProduct = otherReview.getProduct();
            /* thisProduct -> otherProduct 편차 구하기 */
            updateMemberSlope(member, thisReview, thisProduct, otherReview, otherProduct);
            /* otherProduct -> thisProduct 편차 구하기 */
            updateMemberSlope(member, otherReview, otherProduct, thisReview, thisProduct);
        }
    }

    private void updateMemberSlope(Member member, Review review, Product thisProduct, Review otherReview, Product otherProduct) {
        Optional<MemberSlope> optionalSlope = memberSlopeRepository
                .findByMemberIdAndProductsId(member.getId(), thisProduct.getId(), otherProduct.getId());

        MemberSlope memberSlope;
        if (optionalSlope.isEmpty()) {
            memberSlope = MemberSlope.builder()
                    .member(member)
                    .thisProduct(thisProduct)
                    .otherProduct(otherProduct)
                    .build();
        } else {
            memberSlope = optionalSlope.get();
        }

        memberSlope.changeDeviationByReview(review.getProductRate() - otherReview.getProductRate());
        memberSlopeRepository.save(memberSlope);
    }

    public void updateProductSlope(Product thisProduct) {
        List<Product> products = productRepository.findAllIdsByReviewSizeNotEqualZero(thisProduct.getId());

        for (Product targetProduct : products) {
            updateProductSlope(thisProduct, targetProduct);
            updateProductSlope(targetProduct, thisProduct);
        }
    }

    private void updateProductSlope(Product product, Product targetProduct) {
        Optional<ProductSlope> optionalSlope = productSlopeRepository
                .findByProductIds(product.getId(), targetProduct.getId());

        ProductSlope productSlope;
        if (optionalSlope.isEmpty()) {
            productSlope = ProductSlope.builder()
                    .thisProduct(product)
                    .targetProduct(targetProduct)
                    .build();
        } else {
            productSlope = optionalSlope.get();
        }

        Double deviation = memberSlopeRepository.findAvgDeviationByProductsId(product.getId(), targetProduct.getId());
        Long size = memberSlopeRepository.findCountByProductsId(product.getId(), targetProduct.getId());

        productSlope.changeDeviation(deviation, size);
        productSlopeRepository.save(productSlope);
    }

    /* TODO: 2023/06/04 제품을 추천해주는 함수 - 작성한 리뷰가 존재하지 않으면 추천 X */
}
