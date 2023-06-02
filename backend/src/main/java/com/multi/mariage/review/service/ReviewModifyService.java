package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import com.multi.mariage.hashtag.service.HashtagService;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.domain.ReviewHashtagRepository;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.request.ReviewModifyRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewModifyService {

    private final FoodCategoryService foodCategoryService;
    private final ReviewRepository reviewRepository;
    private final ReviewHashtagService reviewHashtagService;
    private final ImageService imageService;
    private final MemberFindService memberFindService;
    private final ProductFindService productFindService;
    private final WeatherService weatherService;
    private final StorageService storageService;
    private final ReviewHashtagRepository reviewHashtagRepository;
    private final ReviewFindService reviewFindService;
    private final HashtagService hashtagService;
    private final HashtagRepository hashtagRepository;

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
        review.setFoodCategory(foodCategory);

        return reviewRepository.save(review);
    }

    public Review update(ReviewModifyRequest request) {
        Image image = getImage(request.getNewFoodImageId());       // 새로운 음식 이미지를 찾아옴
        Product product = productFindService.findById(request.getProductId());
        Food foodCategory = getFoodCategory(request.getFoodCategory(), product);
        Review review = reviewFindService.findById(request.getId());
        Set<ReviewHashtag> reviewHashtags = review.getReviewHashtags(); //해당 리뷰에 대한 해시태그들

        review.setFoodCategory(foodCategory);       // 푸드카테고리 변경
        removeImage(request.getFoodImageId());      // 저장된 기존 음식 이미지 삭제

        if (!request.getHashtags().isEmpty()) {     // 해시태그 업데이트
            removeAllReviewHashTags(review, reviewHashtags);
            saveHashTags(request, review);
        }

        review.changeImage(image);
        review.update(request);

        return review;
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

    private void removeImage(Long imageId) {
        Image image = storageService.findById(imageId);

        storageService.remove(image);
    }

    private void removeAllReviewHashTags(Review review, Set<ReviewHashtag> reviewHashtags) {
        removeHashtags(reviewHashtags);   // 기존 해시태그 삭제
        deleteAllByReview(review);
        reviewHashtags.clear();
    }

    private void removeHashtags(Set<ReviewHashtag> reviewHashtags) {
        for (ReviewHashtag reviewHashtag : reviewHashtags) {
            Hashtag hashtag = reviewHashtag.getHashtag();
            Review review = reviewHashtag.getReview();

            review.removeHashTag(reviewHashtag);

            if (hashtag.getReviewHashTags().isEmpty()) {
                hashtagRepository.delete(hashtag);
            }
        }
    }

    @Transactional
    public void deleteAllByReview(Review review) {
        reviewHashtagRepository.deleteAllByReview(review);
    }

    private void saveHashTags(ReviewModifyRequest request, Review review) {
        List<String> hashtagNames = request.getHashtags();
        reviewHashtagService.saveAll(hashtagNames, review);
    }
}
