package com.multi.mariage.review.controller;

import com.multi.mariage.review.dto.request.ReviewDetailRequest;
import com.multi.mariage.review.dto.request.ReviewFindRequest;
import com.multi.mariage.review.dto.response.MemberProfileResponse;
import com.multi.mariage.review.dto.response.MemberReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.service.ReviewFindService;
import lombok.RequiredArgsConstructor;
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
                                                                         ReviewDetailRequest request) {
        ProductReviewsResponse response = reviewFindService.findReviewsByProductId(productId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/review/{memberId}/ratings")
    public ResponseEntity<MemberReviewInfoResponse> findProductsAndRatedReviewsByMemberId(@PathVariable("memberId") Long memberId,
                                                                                          ReviewFindRequest cond) {
        MemberReviewInfoResponse response = reviewFindService.findProductsAndRatedReviewsByMemberId(memberId, cond);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/review/{memberId}/likes")
    public ResponseEntity<MemberReviewInfoResponse> findProductsAndLikedReviewsByMemberId(@PathVariable("memberId") Long memberId,
                                                                                          ReviewFindRequest cond) {
        MemberReviewInfoResponse response = reviewFindService.findProductsAndLikedReviewsByMemberId(memberId, cond);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/review/{memberId}")
    public ResponseEntity<MemberProfileResponse> findMemberProfile(@PathVariable("memberId") Long memberId) {
        MemberProfileResponse response = reviewFindService.findMemberProfile(memberId);
        return ResponseEntity.ok(response);
    }
}
