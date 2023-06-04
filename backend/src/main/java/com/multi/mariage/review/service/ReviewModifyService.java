package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.like.service.LikeService;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.request.ReviewUpdateRequest;
import com.multi.mariage.review.dto.response.ReviewUpdateResponse;
import com.multi.mariage.review.dto.response.UpdateReviewImageResponse;
import com.multi.mariage.review.exception.ReviewErrorCode;
import com.multi.mariage.review.exception.ReviewException;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ReviewModifyService {

    private final FoodCategoryService foodCategoryService;
    private final ImageService imageService;
    private final MemberFindService memberFindService;
    private final ProductFindService productFindService;
    private final WeatherService weatherService;
    private final LikeService likeService;
    private final ReviewFindService reviewFindService;
    private final ReviewHashtagService reviewHashtagService;
    private final StorageService storageService;
    private final ReviewRepository reviewRepository;

    public Review save(AuthMember authMember, ReviewSaveRequest request) {
        Weather weather = weatherService.findLatestWeather();
        Member member = memberFindService.findById(authMember.getId());
        Product product = productFindService.findById(request.getProductId());
        Food foodCategory = getFoodCategory(request.getFoodCategory(), product);
        Image image = getImage(request.getFoodImageId());

        Review review = Review.from(request);

        reviewHashtagService.saveAll(request.getHashtags(), review);

        review.setMember(member);
        review.setProduct(product);
        review.setWeather(weather);
        review.changeImage(image);
        review.changeFoodCategory(foodCategory);

        return reviewRepository.save(review);
    }

    public ReviewUpdateResponse update(AuthMember authMember, ReviewUpdateRequest request) {

        Product product = productFindService.findById(request.getProductId());
        Food foodCategory = getFoodCategory(request.getFoodCategory(), product);
        Review review = reviewFindService.findByIdToUpdate(request.getReviewId());
        Set<ReviewHashtag> reviewHashtags = review.getReviewHashtags();
        Image image = getImage(review.getImage().getId());

        validateOwnerByReview(authMember.getId(), review);

        review.changeFoodCategory(foodCategory);
        String imageUrl = getImageUrl(request, review, image);
        List<ReviewHashtag> hashTagNames = getReviewHashtagList(request, review, reviewHashtags);
        review.update(request);

        return ReviewUpdateResponse.from(review, imageUrl, hashTagNames);
    }

    private Image getImage(Long imageId) {
        if (imageId == null) {
            return null;
        }
        return imageService.findById(imageId);
    }

    private Food getFoodCategory(FoodCategory foodCategory, Product product) {
        if (foodCategory == null) {
            return null;
        }
        return foodCategoryService.findProductWithCategory(foodCategory, product);
    }

    public void delete(AuthMember authMember, Long reviewId) {
        Review review = reviewFindService.findByIdToDelete(reviewId);

        validateOwnerByReview(authMember.getId(), review);

        removeImageByReview(review);
        foodCategoryService.removeByReview(review);
        reviewHashtagService.removeAllByReview(review);
        likeService.removeAllByReview(review);
        review.removeRelated();

        reviewRepository.delete(review);
    }

    private void removeImageByReview(Review review) {
        Image image = review.getImage();
        if (image != null) {
            storageService.remove(image);
            review.changeImage(null);
        }
    }

    private void validateOwnerByReview(Long memberId, Review review) {
        if (isNotOwner(memberId, review)) {
            throw new ReviewException(ReviewErrorCode.MEMBER_IS_NOT_OWNER);
        }
    }

    private boolean isNotOwner(Long memberId, Review review) {
        return !memberId.equals(review.getMember().getId());
    }

    public String updateImage(Review review, ReviewUpdateRequest request) {

        Image image = imageService.findById(request.getNewImageId());

        review.changeImage(image);
        String imageUrl = imageService.getImageUrl(review.getImage().getName());
        return imageUrl;
    }

    private List<ReviewHashtag> getReviewHashtagList(ReviewUpdateRequest request, Review review, Set<ReviewHashtag> reviewHashtags) {
        List<ReviewHashtag> hashTagNames = new ArrayList<>();
        if (request.getHashtags() != null && !request.getHashtags().isEmpty()) {     // 해시태그 업데이트
            reviewHashtags.clear();
            reviewHashtagService.removeAllByReview(review);
            hashTagNames = reviewHashtagService.saveAll(request.getHashtags(), review);
        } else {
            hashTagNames.addAll(reviewHashtags);
        }
        return hashTagNames;
    }

    private String getImageUrl(ReviewUpdateRequest request, Review review, Image image) {
        String imageUrl = imageService.getImageUrl(image.getName());    // 현재 리뷰 이미지 경로

        if (request.getNewImageId() != null) {  // 이미지 업데이트
            removeImageByReview(review);
            imageUrl = updateImage(review, request);
        }
        return imageUrl;
    }
}
