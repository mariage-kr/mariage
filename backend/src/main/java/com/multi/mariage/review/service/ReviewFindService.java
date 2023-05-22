package com.multi.mariage.review.service;


import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.resonse.ProductReviewsResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewFindService {
    private final ProductFindService productFindService;
    private final MemberFindService memberFindService;
    private final ReviewRepository reviewRepository;

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public ProductReviewsResponse findReviewsByProductId(Long productId, int pageSize, int pageNumber, Long memberId) {
        Product product = productFindService.findById(productId);

        Member member = null;
        if (memberId != null) {
            member = memberFindService.findById(memberId);
        }

        /* TODO: 2023/05/22 해당 제품의 리뷰 정보를 페이징해서 가져오기 */
        return null;
    }
}
