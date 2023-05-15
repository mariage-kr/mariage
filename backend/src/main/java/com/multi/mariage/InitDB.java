package com.multi.mariage;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberService;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.service.ProductService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class InitDB {

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

        private void imageSetUp() {
            Image image = new Image("product/chamisul.png");

            saveImage1 = storageRepository.save(image);
        }

        public void init() {
            imageSetUp();
            ProductSaveRequest product1 = ProductSaveRequest.builder()
                    .name("참이슬")
                    .country(Country.KOREA)
                    .level(16.5)
                    .info("1998년 10월 19일 국내 소주 시장에 첫선을 보인 참이슬은 소주는 25도라는 상식을 깨며, 독한 소주의 이미지를 ‘부드럽고 깨끗하게’ 바꿔 놓은\n" +
                            "국내 소주 최고의 브랜드입니다.")
                    .upperCategory(DrinkUpperCategory.LOCAL_SOJU)
                    .lowerCategory(DrinkLowerCategory.NORMAL_SOJU)
                    .imageId(saveImage1.getId())
                    .build();
            productService.save(product1);
        }
    }
}
