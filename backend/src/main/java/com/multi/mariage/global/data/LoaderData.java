package com.multi.mariage.global.data;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.global.data.Fixture.ProductFixture;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Component

public class LoaderData {

    private final InitMemberService memberService;
    private final InitProductService productService;
    private final InitReviewService reviewService;

    @PostConstruct
    public void init() {
        memberService.init();
        productService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberModifyService memberService;

        public void init() {
            MemberSignupRequest request = MemberSignupRequest.builder()
                    .name("마리")
                    .email("mari1234@gmail.com")
                    .birth(LocalDate.now())
                    .password("qwer1234!@")
                    .nickname("마리아주")
                    .build();

            memberService.signup(request);
        }
    }

    @RequiredArgsConstructor
    @Component
    static class InitProductService {
        private final ProductModifyService productModifyService;
        private final StorageRepository storageRepository;

        private Image saveImage1;
        private Image saveImage2;
        private Image saveImage3;
        private Image saveImage4;
        private Image saveImage5;

        private void imageSetUp() {
            saveImage1 = storageRepository.save(new Image("product/chamisul.png"));
            saveImage2 = storageRepository.save(new Image("product/chumchurum.png"));
            saveImage3 = storageRepository.save(new Image("product/ganbareotosang.png"));
            saveImage4 = storageRepository.save(new Image("product/ilpoomjinro.png"));
            saveImage5 = storageRepository.save(new Image("product/suntory.png"));
        }

        public void init() {
            imageSetUp();
            productModifyService.save(ProductFixture.참이슬.toProductSaveRequest(saveImage1.getId()));
            productModifyService.save(ProductFixture.처음처럼.toProductSaveRequest(saveImage2.getId()));
            productModifyService.save(ProductFixture.간바레오또상.toProductSaveRequest(saveImage3.getId()));
            productModifyService.save(ProductFixture.일품진로.toProductSaveRequest(saveImage4.getId()));
            productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(saveImage5.getId()));
        }
    }

    @RequiredArgsConstructor
    @Component
    static class InitReviewService {
        private final ReviewModifyService reviewModifyService;
        private final StorageRepository storageRepository;

        /* TODO: 2023/05/17 추후 더미데이터를 추가할 예정 */
        public void init() {
            Image image = storageRepository.save(new Image("product/chamisul.png"));
            ReviewSaveRequest request = ReviewSaveRequest.builder()
                    .productId(1L)
                    .productRate(4)
                    .content("리뷰")
                    .foodRate(3)
                    .foodCategory(FoodCategory.ASIAN)
                    .foodImageId(image.getId())
                    .hashtags(List.of("참이슬", "쌀국수", "야식"))
                    .build();
            reviewModifyService.save(new AuthMember(1L), request);
        }
    }
}
