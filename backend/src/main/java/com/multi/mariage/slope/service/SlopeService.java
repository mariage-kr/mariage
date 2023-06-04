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

import java.util.*;

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
        List<Review> memberReviews = reviewRepository.findAllByMemberIdAndProductId(member.getId(), thisProduct.getId());

        for (Review otherReview : memberReviews) {
            Product otherProduct = otherReview.getProduct();
            updateMemberSlope(member, thisReview, thisProduct, otherReview, otherProduct);
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

    @Transactional
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
        productSlope.changeDeviation(deviation);
        productSlopeRepository.save(productSlope);
    }

    public List<Map.Entry<Long, Double>> recommendSlope(Long memberId, int size) {
        List<Review> memberReviews = reviewRepository.findAllByMemberId(memberId);

        Map<Long, Double> productData = new HashMap<>();
        if (memberReviews.isEmpty()) {
            return Collections.emptyList();
        }

        List<Long> memberReviewProductIds = getMemberReviewProductIds(memberReviews);
        List<ProductSlope> productSlopes = productSlopeRepository.findAllByMemberReviewProductIds(memberReviewProductIds);
        getRecommendProductMap(memberReviews, productData, productSlopes);

        List<Map.Entry<Long, Double>> entryList = getSortDataList(productData);
        return entryList.subList(0, size);
    }

    /**
     * 사용자가 작성한 제품의 식별 번호들을 추출한다.
     *
     * @param memberReviews 사용자가 작성한 리뷰 목록
     * @return 사용자가 작성한 제품의 식별 번호들
     */
    private List<Long> getMemberReviewProductIds(List<Review> memberReviews) {
        return memberReviews.stream()
                .map(review -> review.getProduct().getId())
                .distinct()
                .toList();
    }

    private void getRecommendProductMap(List<Review> memberReviews, Map<Long, Double> productData, List<ProductSlope> productSlopes) {
        Long productId = -1L;
        double totalPreference = 0D;
        Long memberSize = 0L;
        for (ProductSlope productSlope : productSlopes) {
            Long newProductId = productSlope.getThisProduct().getId();
            if (!Objects.equals(productId, newProductId)) {
                // 데이터 저장
                if (productId != -1 && memberSize != 0) {
                    productData.put(productId, totalPreference / memberSize);
                }
                // 사용자가 추천 받을 제품 후보의 식별 번호
                productId = newProductId;
                // 초기화
                totalPreference = 0D;
                memberSize = 0L;
            }

            double avgRate = getAvgRate(memberReviews, productSlope);

            /* 인원수 * (기존 제품의 선호도 + 편차 평균) */
            totalPreference += productSlope.getSize() * (avgRate + productSlope.getDeviation());
            memberSize += productSlope.getSize();
        }
    }

    /**
     * 사용자가 해당 제품에 작성한 리뷰의 평균 점수를 구한다.
     *
     * @param memberReviews 사용자가 작성한 리뷰의 목록
     * @param productSlope  제품을 추천을 위한 도구
     * @return 제품의 평균 리뷰 점수
     */
    private double getAvgRate(List<Review> memberReviews, ProductSlope productSlope) {
        List<Review> reviews = getReviewsByProductId(memberReviews, productSlope.getTargetProduct().getId());
        int totalRate = 0;
        for (Review review : reviews) {
            totalRate += review.getProductRate();
        }
        return (double) totalRate / reviews.size();
    }

    /**
     * 제품 식별 번호로 사용자가 작성한 리뷰를 추출한다.
     *
     * @param memberReviews 사용자가 작성한 리뷰의 목록
     * @param productId     제품의 식별 번호
     * @return 해당 제품에 작성한 사용자의 리뷰 목록l
     */
    private List<Review> getReviewsByProductId(List<Review> memberReviews, Long productId) {
        return memberReviews.stream().filter(review -> review.getProduct().getId().equals(productId)).toList();
    }

    private List<Map.Entry<Long, Double>> getSortDataList(Map<Long, Double> productData) {
        List<Map.Entry<Long, Double>> entryList = new LinkedList<>(productData.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList;
    }
}
