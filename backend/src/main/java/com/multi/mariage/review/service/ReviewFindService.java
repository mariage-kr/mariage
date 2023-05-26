package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.ProductContentVO;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.MyReviewsPagingCond;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.multi.mariage.review.dto.response.MyReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import com.multi.mariage.review.vo.ProductReviewVO;
import com.multi.mariage.review.vo.my.review.MyProductReviewVO;
import com.multi.mariage.review.vo.my.review.MyReviewVO;
import com.multi.mariage.review.vo.my.review.ReviewContentVO;
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
    private final ProductRepository productRepository;
    private final ImageService imageService;

    /* TODO: 2023/05/24 추후 코드 리팩토링 */
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

    public MyReviewInfoResponse findProductsAndReviewsByMemberId(Long memberId, int pageNumber, int pageSize, String sort) {   // 사용자가 쓴 리뷰를 모두 찾으면서 각각의 리뷰에 대한 제품 조회 가능

        MyReviewsPagingCond cond = MyReviewsPagingCond.builder()
                .memberId(memberId)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .sort(sort)
                .build();

        List<Review> reviews = reviewRepository.findReviewsByMemberId(cond);
        Long totalCount = reviewRepository.findReviewsCountByMemberId(memberId);

        List<MyReviewVO> productAndReviewList = getReviewListByMemberId(reviews, memberId);
        int totalPages = getTotalPages(pageSize, totalCount);

        return MyReviewInfoResponse.builder()
                .contents(productAndReviewList)
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
                .review(contentVO)
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

    private List<MyReviewVO> getReviewListByMemberId(List<Review> reviews, Long memberId) {
        return reviews.stream()
                .map(review -> {
                    ProductContentVO productContent = getProductContentFrom(review.getProduct().getId());
                    MyProductReviewVO reviewContent = getMyReviewContent(review,
                            getProductReviewMemberFrom(review),
                            getMyReviewContentFrom(review),
                            ProductReviewFoodVO.from(review),
                            getProductReviewLikeFrom(review, memberId),
                            getHashtags(review));
                    return MyReviewVO.from(productContent, reviewContent);
                })
                .toList();
    }

    public ProductContentVO getProductContentFrom(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));

        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductContentVO.from(product, imageUrl, product.getAvgReviewRate());
    }

    private MyProductReviewVO getMyReviewContent(Review review,
                                                 ProductReviewMemberVO member,
                                                 ReviewContentVO content,
                                                 ProductReviewFoodVO food,
                                                 ProductReviewLikeVO like,
                                                 List<String> hashtags) {
        return MyProductReviewVO.builder()
                .id(review.getId())
                .member(member)
                .review(content)
                .food(food)
                .like(like)
                .hashtags(hashtags)
                .build();
    }

    private ReviewContentVO getMyReviewContentFrom(Review review) {
        return ReviewContentVO.builder()
                .date(convertToLocalDateFormat(review.getDate()))
                .rate(review.getProductRate())
                .content(review.getContent())
                .img(imageService.getImageUrl(review.getImage().getName()))
                .build();
    }
}
