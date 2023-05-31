package com.multi.mariage.review.dto.cond;


import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewDetailRequest;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewsPagingCond {
    private Long productId;
    private int pageSize;
    private int pageNumber;
    private String sort;
    @Nullable
    private FoodCategory foodCategory;
    @Nullable
    private Integer rate;

    /* TODO: 2023/05/22 추후 데이터 중복을 방지하기 위한 리뷰의 식별자 필요 */
    @Builder
    private ReviewsPagingCond(Long productId, int pageSize, int pageNumber, String sort, FoodCategory foodCategory,
                              Integer rate) {
        this.productId = productId;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sort = sort;
        this.foodCategory = foodCategory;
        this.rate = rate;
    }

    public static ReviewsPagingCond from(Long productId, ReviewDetailRequest request) {
        return ReviewsPagingCond.builder()
                .productId(productId)
                .foodCategory(request.getCategory())
                .sort(request.getSort())
                .pageNumber(request.getPageNumber())
                .pageSize(request.getPageSize())
                .rate(request.getRate())
                .build();
    }
}
