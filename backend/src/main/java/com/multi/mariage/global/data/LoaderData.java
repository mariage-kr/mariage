package com.multi.mariage.global.data;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.global.data.Fixture.MemberFixture;
import com.multi.mariage.global.data.Fixture.ProductFixture;
import com.multi.mariage.global.data.Fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.dto.resonse.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
//@Profile("dev")
public class LoaderData {

    private static Member 마리;
    private static Product 참이슬;
    private static Product 처음처럼;
    private static ReviewSaveResponse 참이슬과고기;
    private static ReviewSaveResponse 처음처럼과고기;
    private final InitMemberService memberService;
    private final InitProductService productService;
    private final InitReviewService reviewService;

    @PostConstruct
    public void init() {
        memberService.init();
        productService.init();
        reviewService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberModifyService memberService;

        public void init() {
            마리 = memberService.signup(MemberFixture.MARI.toSignupRequest());
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
            참이슬 = productModifyService.save(ProductFixture.참이슬.toProductSaveRequest(saveImage1.getId()));
            처음처럼 = productModifyService.save(ProductFixture.처음처럼.toProductSaveRequest(saveImage2.getId()));
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
            ReviewFixture fixture1 = ReviewFixture.참이슬과_고기;
            ReviewFixture fixture2 = ReviewFixture.처음처럼과_고기;
            Image image1 = storageRepository.save(new Image(fixture1.getFoodImagePath()));
            Image image2 = storageRepository.save(new Image(fixture2.getFoodImagePath()));
            참이슬과고기 = reviewModifyService.save(new AuthMember(마리.getId()), fixture1.toSaveRequest(참이슬.getId(), image1.getId()));
            처음처럼과고기 = reviewModifyService.save(new AuthMember(마리.getId()), fixture2.toSaveRequest(처음처럼.getId(), image2.getId()));
        }
    }
}
