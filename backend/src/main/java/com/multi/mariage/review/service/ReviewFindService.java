package com.multi.mariage.review.service;


import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.multi.mariage.review.dto.resonse.ProductReviewsResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import com.multi.mariage.review.vo.ProductReviewVO;
import com.multi.mariage.review.vo.product.ProductReviewContentVO;
import com.multi.mariage.review.vo.product.ProductReviewFoodVO;
import com.multi.mariage.review.vo.product.ProductReviewLikeVO;
import com.multi.mariage.review.vo.product.ProductReviewMemberVO;
import com.multi.mariage.storage.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReviewFindService {
    private final ReviewRepository reviewRepository;
    private final ImageService imageService;

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public ProductReviewsResponse findReviewsByProductId(Long productId, Long memberId, int pageNumber, int pageSize) {
        ReviewsPagingCond cond = ReviewsPagingCond.builder()
                .productId(productId)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .build();

        List<Review> reviews = reviewRepository.findReviewsByProductId(cond);

        for (Review review : reviews) {
            System.out.println("review " + review);
        }

        List<ProductReviewVO> reviewVOList = getProductReviewList(reviews);
        Long totalCount = reviewRepository.findReviewsCountByProductId(productId);
        int totalPages = getTotalPages(pageSize, totalCount);

        return ProductReviewsResponse.builder()
                .reviews(reviewVOList)
                .pageSize(pageSize)
                .totalCount(totalCount)
                .pageNumber(pageNumber)
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(pageNumber))
                .isLastPage(isLastPage(pageNumber, totalPages))
                .build();
    }

    private List<ProductReviewVO> getProductReviewList(List<Review> reviews) {
        return reviews.stream()
                .map(review -> getProductReview(review,
                        getProductReviewMemberFrom(review),
                        getProductReviewContentFrom(review),
                        getProductReviewFoodFrom(review),
                        getProductReviewLikeFrom(review)))
                .toList();
    }

    private ProductReviewVO getProductReview(Review review,
                                             ProductReviewMemberVO memberVO,
                                             ProductReviewContentVO contentVO,
                                             ProductReviewFoodVO foodVO,
                                             ProductReviewLikeVO likeVO) {
        return ProductReviewVO.builder()
                .id(review.getId())
                .member(memberVO)
                .content(contentVO)
                .food(foodVO)
                .like(likeVO)
                .build();
    }

    private ProductReviewMemberVO getProductReviewMemberFrom(Review review) {
        Member reviewWriter = review.getMember();
        return ProductReviewMemberVO.builder()
                .id(reviewWriter.getId())
                .nickname(reviewWriter.getNickname())
                .img("http://localhost:8080/image/profile.png")
//                .img(imageService.getImageUrl(reviewWriter.getImage().getName()))
                .build();
    }

    private ProductReviewContentVO getProductReviewContentFrom(Review review) {
        return ProductReviewContentVO.builder()
                /* TODO: 2023/05/22 날짜의 형식을 변경 */
                .date(review.getDate().toString())
                .rate(review.getProductRate())
                .content(review.getContent())
                .img(imageService.getImageUrl(review.getImage().getName()))
                .weather(review.getWeather().getValue().name())
                .build();
    }

    private ProductReviewFoodVO getProductReviewFoodFrom(Review review) {
        return ProductReviewFoodVO.builder()
                .id(review.getFoodCategory().getId())
                .name(review.getFoodCategory().getName())
                .rate(review.getFoodRate())
                .build();
    }

    private ProductReviewLikeVO getProductReviewLikeFrom(Review review) {
        return ProductReviewLikeVO.builder()
                .count(review.getLikes().size())
                /* TODO: 2023/05/22 로그인한 유저이면 좋아요 정보를 얻어 오기 */
                .isLiked(false)
                .build();
    }

    private int getTotalPages(int pageSize, double totalCount) {
        return (int) Math.ceil(totalCount / pageSize);
    }

    private boolean isFirstPage(int pageNumber) {
        return pageNumber == 1;
    }

    private boolean isLastPage(int pageNumber, int totalPages) {
        return pageNumber >= totalPages;
    }
}
