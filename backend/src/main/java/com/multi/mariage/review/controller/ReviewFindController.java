package com.multi.mariage.review.controller;

import com.multi.mariage.review.dto.resonse.ProductReviewsResponse;
import com.multi.mariage.review.service.ReviewFindService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ReviewFindController {
    private final ReviewFindService reviewFindService;

    @GetMapping("/review/product")
    public ResponseEntity<ProductReviewsResponse> findReviewsByProductId(@Param("productId") Long productId,
                                                                         @Param("pageSize") int pageSize,
                                                                         @Param("pageNumber") int pageNumber,
                                                                         @Param("memberId") @Nullable Long memberId) {
        ProductReviewsResponse response = reviewFindService.findReviewsByProductId(productId, pageSize, pageNumber, memberId);
        return ResponseEntity.ok(response);
    }
}
