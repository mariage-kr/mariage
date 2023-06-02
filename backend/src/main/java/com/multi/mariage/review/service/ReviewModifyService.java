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
import org.springframework.web.multipart.MultipartFile;

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
        Review review = reviewFindService.findById(request.getId());
        validateOwnerByReview(authMember.getId(), review);
        Set<ReviewHashtag> reviewHashtags = review.getReviewHashtags();
        review.changeFoodCategory(foodCategory);

        if (!request.getHashtags().isEmpty()) {     // 해시태그 업데이트
            reviewHashtagService.removeAllByReview(review);
            reviewHashtags.clear();
        }

        List<ReviewHashtag> hashTagNames = reviewHashtagService.saveAll(request.getHashtags(), review);
        UpdateReviewImageResponse newImage = updateImage(review, request.getFile());
        review.update(request);

        return ReviewUpdateResponse.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(review.getFoodCategory().getCategory())
                .imagePath(newImage.getImagePath())
                .hashtags(hashTagNames)
                .build();
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

    public UpdateReviewImageResponse updateImage(Review review, MultipartFile file) {

        if (review.getImage() != null) {
            removeImageByReview(review);
        }

        Image image = storageService.save(file);
        review.changeImage(image);

        String filePath = storageService.getFilePath(image.getName());
        return new UpdateReviewImageResponse(filePath);
    }
}
