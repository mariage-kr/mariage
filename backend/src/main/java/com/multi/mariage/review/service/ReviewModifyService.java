package com.multi.mariage.review.service;


import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewModifyService {

    private final ReviewRepository reviewRepository;
    private final ImageService imageService;
    private final MemberFindService memberFindService;
    private final ProductFindService productFindService;
    private final WeatherService weatherService;

    public ReviewSaveResponse save(AuthMember authMember, ReviewSaveRequest request) {
        Member member = memberFindService.findById(authMember.getId());
        Product product = productFindService.findById(request.getProductId());

        Image image = imageService.findById(request.getFoodImageId());
        LocalDate now = LocalDate.now(ZoneId.of("Asia/Seoul"));

        Review review = Review.builder()
                .productRate(request.getProductRate())
                .content(request.getContent())
                .foodRate(request.getFoodRate())
                .date(now)
                .foodCategory(request.getFoodCategory())
                .image(image)
                .build();

        /* TODO: 2023/05/17 해시 태그 로직 필요 */

        /* TODO: 2023/05/17 weather Service에서 정보를 가져와서 담기 */
        review.setWeather(null);
        review.setMember(member);
        review.setProduct(product);

        Review savedReview = reviewRepository.save(review);
        return new ReviewSaveResponse(savedReview.getId());
    }
}
