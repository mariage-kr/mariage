package com.multi.mariage.review.service;


import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReviewFindService extends PagingUtil {
    private final ReviewRepository reviewRepository;
    private final ImageService imageService;

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public ProductReviewsResponse findReviewsByProductId(Long productId, Long memberId,
                                                         int pageNumber, int pageSize, String sort) {
        ReviewsPagingCond cond = ReviewsPagingCond.builder()
                .productId(productId)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .sort(sort)
                .build();

        List<Review> reviews = reviewRepository.findReviewsByProductId(cond);
        Long totalCount = reviewRepository.findReviewsCountByProductId(productId);

        List<ProductReviewVO> reviewVOList = getProductReviewList(reviews, memberId);
        int totalPages = getTotalPages(pageSize, totalCount);

        return ProductReviewsResponse.builder()
                .contents(reviewVOList)
                .pageSize(pageSize)
                .totalCount(totalCount)
                .pageNumber(pageNumber)
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(pageNumber))
                .isLastPage(isLastPage(pageNumber, totalPages))
                .build();
    }

    private List<ProductReviewVO> getProductReviewList(List<Review> reviews, Long memberId) {
        return reviews.stream()
                .map(review -> getProductReview(review,
                        getProductReviewMemberFrom(review),
                        getProductReviewContentFrom(review),
                        ProductReviewFoodVO.from(review),
                        getProductReviewLikeFrom(review, memberId),
                        getHashtags(review)))
                .toList();
    }

    private ProductReviewVO getProductReview(Review review,
                                             ProductReviewMemberVO memberVO,
                                             ProductReviewContentVO contentVO,
                                             ProductReviewFoodVO foodVO,
                                             ProductReviewLikeVO likeVO,
                                             List<String> hashtags) {
        return ProductReviewVO.builder()
                .id(review.getId())
                .member(memberVO)
                .content(contentVO)
                .food(foodVO)
                .like(likeVO)
                .hashtags(hashtags)
                .build();
    }

    private ProductReviewMemberVO getProductReviewMemberFrom(Review review) {
        Member reviewWriter = review.getMember();
        String imageName = reviewWriter.getImage() != null ? reviewWriter.getImage().getName() : "profile.png";

        return ProductReviewMemberVO.builder()
                .id(reviewWriter.getId())
                .nickname(reviewWriter.getNickname())
                .img(imageService.getImageUrl(imageName))
                .build();
    }

    private ProductReviewContentVO getProductReviewContentFrom(Review review) {
        return ProductReviewContentVO.builder()
                .date(convertToLocalDateFormat(review.getDate()))
                .rate(review.getProductRate())
                .content(review.getContent())
                .img(imageService.getImageUrl(review.getImage().getName()))
                .weather(review.getWeather().getValue().name())
                .build();
    }

    private String convertToLocalDateFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
        return date.format(formatter);
    }

    private ProductReviewLikeVO getProductReviewLikeFrom(Review review, Long memberId) {
        boolean isLiked = review.getLikes().stream()
                .anyMatch(like -> Objects.equals(like.getMember().getId(), memberId));

        return ProductReviewLikeVO.builder()
                .count(review.getLikes().size())
                .isLiked(isLiked)
                .build();
    }

    private List<String> getHashtags(Review review) {
        return review.getReviewHashtags().stream()
                .map(ReviewHashtag::getHashtag)
                .map(Hashtag::getName)
                .toList();
    }
}
