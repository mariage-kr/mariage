package com.multi.mariage.global.data;

import com.multi.mariage.global.data.Fixture.ProductFixture;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberService;
import com.multi.mariage.product.service.ProductService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class LoaderData {

    private final InitMemberService memberService;
    private final InitProductService productService;

    @PostConstruct
    public void init() {
        memberService.init();
        productService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberService memberService;

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
        private final ProductService productService;
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
            productService.save(ProductFixture.참이슬.toProduct(saveImage1.getId()));
            productService.save(ProductFixture.처음처럼.toProduct(saveImage2.getId()));
            productService.save(ProductFixture.간바레오또상.toProduct(saveImage3.getId()));
            productService.save(ProductFixture.일품진로.toProduct(saveImage4.getId()));
            productService.save(ProductFixture.산토리_위스키.toProduct(saveImage5.getId()));
        }
    }
}
