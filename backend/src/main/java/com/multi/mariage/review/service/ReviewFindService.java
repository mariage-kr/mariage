package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.like.domain.LikeRepository;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.cond.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.cond.ReviewsPagingCond;
import com.multi.mariage.review.dto.request.ReviewDetailRequest;
import com.multi.mariage.review.dto.request.ReviewFindRequest;
import com.multi.mariage.review.dto.response.MemberProfileResponse;
import com.multi.mariage.review.dto.response.MemberReviewInfoResponse;
import com.multi.mariage.review.dto.response.ProductReviewsResponse;
import com.multi.mariage.review.dto.response.ReviewUpdateInfoResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import com.multi.mariage.review.vo.ProductReviewVO;
import com.multi.mariage.review.vo.member.MemberReviewVO;
import com.multi.mariage.review.vo.member.ProductInfoVO;
import com.multi.mariage.review.vo.member.ReviewContentVO;
import com.multi.mariage.review.vo.member.ReviewInfoVO;
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
    private final ProductFindService productFindService;
    private final MemberFindService memberFindService;
    private final ImageService imageService;
    private final StorageService storageService;
    private final LikeRepository likeRepository;

    /* TODO: 2023/05/24 추후 코드 리팩토링 */
    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public ProductReviewsResponse findReviewsByProductId(Long productId, ReviewDetailRequest request) {
        ReviewsPagingCond cond = ReviewsPagingCond.from(productId, request);

        List<Review> reviews = reviewRepository.findReviewsByProductId(cond);
        Long totalCount = reviewRepository.findReviewsCountByProductId(productId, request.getCategory(), request.getRate());

        List<ProductReviewVO> reviewVOList = getProductReviewList(reviews, request.getMemberId());
        int totalPages = getTotalPages(request.getPageSize(), totalCount);

        return ProductReviewsResponse.builder()
                .contents(reviewVOList)
                .pageSize(request.getPageSize())
                .totalCount(totalCount)
                .pageNumber(request.getPageNumber())
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(request.getPageNumber()))
                .isLastPage(isLastPage(request.getPageNumber(), totalPages))
                .build();
    }

    public MemberReviewInfoResponse findProductsAndRatedReviewsByMemberId(Long memberId, ReviewFindRequest cond) {   // 사용자가 쓴 리뷰를 모두 찾으면서 각각의 리뷰에 대한 제품 조회 가능

        MemberReviewsPagingCond pageCond = MemberReviewsPagingCond.builder()
                .memberId(memberId)
                .pageSize(cond.getPageSize())
                .pageNumber(cond.getPageNumber())
                .build();

        List<Review> reviews = reviewRepository.findRatedReviewsByMemberId(pageCond);
        Long totalCount = reviewRepository.findReviewsCountByRatings(memberId);

        List<MemberReviewVO> productAndReviewList = getReviewListByMemberId(reviews, cond.getVisitMemberId());
        int totalPages = getTotalPages(cond.getPageSize(), totalCount);

        return MemberReviewInfoResponse.builder()
                .contents(productAndReviewList)
                .pageSize(cond.getPageSize())
                .totalCount(totalCount)
                .pageNumber(cond.getPageNumber())
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(cond.getPageNumber()))
                .isLastPage(isLastPage(cond.getPageNumber(), totalPages))
                .build();
    }

    public MemberReviewInfoResponse findProductsAndLikedReviewsByMemberId(Long memberId, ReviewFindRequest cond) {   // 사용자가 좋아요한 리뷰를 모두 찾으면서 각각의 리뷰에 대한 제품 조회 가능

        MemberReviewsPagingCond pageCond = MemberReviewsPagingCond.builder()
                .memberId(memberId)
                .pageSize(cond.getPageSize())
                .pageNumber(cond.getPageNumber())
                .build();

        List<Review> reviews = reviewRepository.findLikedReviewsByMemberId(pageCond);
        Long totalCount = reviewRepository.findReviewsCountByLikes(memberId);

        List<MemberReviewVO> productAndReviewList = getReviewListByMemberId(reviews, cond.getVisitMemberId());
        int totalPages = getTotalPages(cond.getPageSize(), totalCount);

        return MemberReviewInfoResponse.builder()
                .contents(productAndReviewList)
                .pageSize(cond.getPageSize())
                .totalCount(totalCount)
                .pageNumber(cond.getPageNumber())
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(cond.getPageNumber()))
                .isLastPage(isLastPage(cond.getPageNumber(), totalPages))
                .build();
    }

    public MemberProfileResponse findMemberProfile(Long memberId) {
        Member member = memberFindService.findById(memberId);

        String email = member.getEmail().substring(0, 5);
        String imageName = member.getImage() != null ? member.getImage().getName() : "profile.png";
        String filePath = storageService.getFilePath(imageName);
        Long reviews = reviewRepository.findReviewsCountByRatings(memberId);
        Long likes = reviewRepository.findReviewsCountByLikes(memberId);

        return MemberProfileResponse.from(email, filePath, member.getNickname(), reviews, likes);
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
                .img(getImageUrl(review.getImage()))
                .weather(review.getWeather().getValue().name())
                .build();
    }

    private String getImageUrl(Image image) {
        if (image == null) {
            return null;
        }
        return imageService.getImageUrl(image.getName());
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
        Product product = productFindService.findById(productId);

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

    public Review findByIdToDelete(Long id) {
        return reviewRepository.findByIdToDelete(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public Review findByIdToUpdate(Long id) {
        return reviewRepository.findByIdToUpdate(id)
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));
    }

    public ReviewUpdateInfoResponse findUpdateReviewInfo(AuthMember authMember, Long reviewId) {
        Review review = reviewRepository.findByIdAndMemberId(reviewId, authMember.getId())
                .orElseThrow(() -> new ReviewException(ReviewErrorCode.REVIEW_IS_NOT_EXISTED));

        Product product = review.getProduct();
        Country country = product.getCountry();
        Food foodCategory = review.getFoodCategory();
        String imageUrl = imageService.getImageUrl(review.getImage().getName());

        return ReviewUpdateInfoResponse.builder()
                .productName(product.getName())
                .productLevel(product.getLevel())
                .countryId(country.getId())
                .countryName(country.getValue())
                .reviewProductRate(review.getProductRate())
                .reviewContent(review.getContent())
                .foodCategoryId(foodCategory.getCategory().getId())
                .foodCategoryName(foodCategory.getCategory().getName())
                .foodCategoryValue(foodCategory.getCategory())
                .foodCategoryRate(review.getFoodRate())
                .imageUrl(imageUrl)
                .hashtags(getHashtags(review))
                .build();
    }
}
