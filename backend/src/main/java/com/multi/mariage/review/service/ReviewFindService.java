package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.dto.response.MyInfoResponse;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.multi.mariage.review.dto.response.MemberProfileResponse;
import com.multi.mariage.review.dto.response.MemberReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import com.multi.mariage.review.vo.ProductReviewVO;
import com.multi.mariage.review.vo.member.write.ReviewInfoVO;
import com.multi.mariage.review.vo.member.write.MemberReviewVO;
import com.multi.mariage.review.vo.member.write.ProductInfoVO;
import com.multi.mariage.review.vo.member.write.ReviewContentVO;
import com.multi.mariage.review.vo.product.ProductReviewContentVO;
import com.multi.mariage.review.vo.product.ProductReviewFoodVO;
import com.multi.mariage.review.vo.product.ProductReviewLikeVO;
import com.multi.mariage.review.vo.product.ProductReviewMemberVO;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
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
    private final MemberRepository memberRepository;
    private final ImageService imageService;
    private final StorageService storageService;

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

    public MemberReviewInfoResponse findProductsAndReviewsByMemberId(Long memberId, int pageNumber, int pageSize, String sort) {   // 사용자가 쓴 리뷰를 모두 찾으면서 각각의 리뷰에 대한 제품 조회 가능

        MemberReviewsPagingCond cond = MemberReviewsPagingCond.builder()
                .memberId(memberId)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .sort(sort)
                .build();

        List<Review> reviews = reviewRepository.findReviewsByMemberId(cond);
        Long totalCount = reviewRepository.findReviewsCountByMemberId(memberId);

        List<MemberReviewVO> productAndReviewList = getReviewListByMemberId(reviews, memberId);
        int totalPages = getTotalPages(pageSize, totalCount);

        return MemberReviewInfoResponse.builder()
                .contents(productAndReviewList)
                .pageSize(pageSize)
                .totalCount(totalCount)
                .pageNumber(pageNumber)
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(pageNumber))
                .isLastPage(isLastPage(pageNumber, totalPages))
                .build();
    }

    public MemberReviewInfoResponse findProductsAndReviewsByMemberLike(Long memberId, int pageNumber, int pageSize, String sort) {   // 사용자가 쓴 리뷰를 모두 찾으면서 각각의 리뷰에 대한 제품 조회 가능

        MemberReviewsPagingCond cond = MemberReviewsPagingCond.builder()
                .memberId(memberId)
                .pageSize(pageSize)
                .pageNumber(pageNumber)
                .sort(sort)
                .build();

        List<Review> reviews = reviewRepository.findReviewsByMemberLike(cond);
        Long totalCount = reviewRepository.findReviewsCountByMemberLike(memberId);

        List<MemberReviewVO> productAndReviewList = getReviewListByMemberId(reviews, memberId);
        int totalPages = getTotalPages(pageSize, totalCount);

        return MemberReviewInfoResponse.builder()
                .contents(productAndReviewList)
                .pageSize(pageSize)
                .totalCount(totalCount)
                .pageNumber(pageNumber)
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(pageNumber))
                .isLastPage(isLastPage(pageNumber, totalPages))
                .build();
    }

    public MemberProfileResponse findMemberProfile(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_IS_NOT_EXISTED));

        String imageName = getImageName(member.getImage());
        String filePath = storageService.getFilePath(imageName);
        Long reviews = reviewRepository.findReviewsCountByMemberId(memberId);
        Long likes = reviewRepository.findReviewsCountByMemberLike(memberId);

        return MemberProfileResponse.from(member.getEmail().substring(0, 5), filePath, member.getNickname(), reviews, likes);
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

    private List<MemberReviewVO> getReviewListByMemberId(List<Review> reviews, Long memberId) {
        return reviews.stream()
                .map(review -> {
                    ProductInfoVO productInfo = getProductInfoFrom(review.getProduct().getId());
                    ReviewInfoVO reviewInfo = getMemberReviewInfo(review,
                            getProductReviewMemberFrom(review),
                            getMemberReviewContentFrom(review),
                            ProductReviewFoodVO.from(review),
                            getProductReviewLikeFrom(review, memberId),
                            getHashtags(review));
                    return MemberReviewVO.from(productInfo, reviewInfo);
                })
                .toList();
    }

    public ProductInfoVO getProductInfoFrom(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));

        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoVO.from(product, imageUrl, product.getAvgReviewRate());
    }

    private ReviewInfoVO getMemberReviewInfo(Review review,
                                             ProductReviewMemberVO member,
                                             ReviewContentVO content,
                                             ProductReviewFoodVO food,
                                             ProductReviewLikeVO like,
                                             List<String> hashtags) {
        return ReviewInfoVO.builder()
                .id(review.getId())
                .member(member)
                .review(content)
                .food(food)
                .like(like)
                .hashtags(hashtags)
                .build();
    }

    private ReviewContentVO getMemberReviewContentFrom(Review review) {
        return ReviewContentVO.builder()
                .date(convertToLocalDateFormat(review.getDate()))
                .rate(review.getProductRate())
                .content(review.getContent())
                .img(imageService.getImageUrl(review.getImage().getName()))
                .build();
    }

    private String getImageName(Image image) {
        return image != null ? image.getName() : "profile.png";
    }
}
