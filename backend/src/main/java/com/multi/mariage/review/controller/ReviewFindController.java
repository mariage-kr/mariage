package com.multi.mariage.review.controller;

import com.multi.mariage.auth.annotation.Authenticated;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.review.dto.response.MyReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.service.ReviewFindService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewFindController {
    private final ReviewFindService reviewFindService;

    /* TODO: 2023/05/23 자식 함수들 테스트 코드 필요 */
    @GetMapping("/review/product/{productId}")
    public ResponseEntity<ProductReviewsResponse> findReviewsByProductId(@PathVariable("productId") Long productId,
                                                                         @Param("memberId") @Nullable Long memberId,
                                                                         @Param("pageNumber") int pageNumber,
                                                                         @Param("pageSize") int pageSize,
                                                                         @Param("sort") @Nullable String sort) {
        ProductReviewsResponse response = reviewFindService.findReviewsByProductId(productId, memberId,
                pageNumber, pageSize, sort);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/review/my/write")
    public ResponseEntity<MyReviewInfoResponse> findProductAndReviewsByMemberId(@Authenticated AuthMember authMember,
                                                                                @Param("pageNumber") int pageNumber,
                                                                                @Param("pageSize") int pageSize,
                                                                                @Param("sort") @Nullable String sort) {
        MyReviewInfoResponse response = reviewFindService.findProductsAndReviewsByMemberId(authMember,
                pageNumber, pageSize, sort);
        return ResponseEntity.ok(response);
    }
}
