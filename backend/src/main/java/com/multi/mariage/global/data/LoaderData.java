package com.multi.mariage.global.data;

import com.multi.mariage.global.data.Fixture.MemberFixture;
import com.multi.mariage.global.data.Fixture.ProductFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.multi.mariage.global.data.Fixture.ProductFixture.values;


@RequiredArgsConstructor
@Component
@Profile("dev")
public class LoaderData {

    private static Member 마리;
    private static Member 수리;
    private static List<Product> productList;
    private final InitMemberService memberService;
    private final InitProductService productService;
    private final InitReviewService reviewService;

    @PostConstruct
    public void init() {
        memberService.init();
        productService.init();
//        reviewService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberModifyService memberService;

        public void init() {
            마리 = memberService.signup(MemberFixture.MARI.toSignupRequest());
            수리 = memberService.signup(MemberFixture.SURI.toSignupRequest());
        }
    }

    @RequiredArgsConstructor
    @Component
    static class InitProductService {
        private final ProductModifyService productModifyService;
        private final StorageRepository storageRepository;

        public void init() {
            for (ProductFixture productFixture : values()) {
                productList.add(saveProduct(productFixture));
            }
        }

        private Product saveProduct(ProductFixture productFixture) {
            Long imageId = storageRepository.save(new Image(productFixture.getImageName())).getId();
            return productModifyService.save(productFixture.toProductSaveRequest(imageId));
        }
    }

    @RequiredArgsConstructor
    @Component
    static class InitReviewService {
        private final ReviewModifyService reviewModifyService;
        private final StorageRepository storageRepository;

        /* TODO: 2023/05/17 추후 더미데이터를 추가할 예정 */
        public void init() {
//            ReviewFixture fixture1 = ReviewFixture.참이슬과_고기;
//            ReviewFixture fixture2 = ReviewFixture.처음처럼과_고기;
//            ReviewFixture fixture3 = ReviewFixture.처음처럼과_피자;
//            ReviewFixture fixture4 = ReviewFixture.처음처럼과_치킨;
//            ReviewFixture fixture5 = ReviewFixture.처음처럼과_회;
//            ReviewFixture fixture6 = ReviewFixture.처음처럼과_피자2;
//            ReviewFixture fixture7 = ReviewFixture.처음처럼과_피자3;
//            ReviewFixture fixture8 = ReviewFixture.처음처럼과_치킨2;
//            Image image1 = storageRepository.save(new Image(fixture1.getFoodImagePath()));
//            Image image2 = storageRepository.save(new Image(fixture2.getFoodImagePath()));
//            Image image3 = storageRepository.save(new Image(fixture3.getFoodImagePath()));
//            Image image4 = storageRepository.save(new Image(fixture4.getFoodImagePath()));
//            Image image5 = storageRepository.save(new Image(fixture5.getFoodImagePath()));
//            참이슬과고기 = reviewModifyService.save(new AuthMember(마리.getId()), fixture1.toSaveRequest(참이슬.getId(), image1.getId()));
//            처음처럼과고기 = reviewModifyService.save(new AuthMember(마리.getId()), fixture2.toSaveRequest(처음처럼.getId(), image2.getId()));
//            처음처럼과피자 = reviewModifyService.save(new AuthMember(마리.getId()), fixture3.toSaveRequest(처음처럼.getId(), image3.getId()));
//            처음처럼과치킨 = reviewModifyService.save(new AuthMember(마리.getId()), fixture4.toSaveRequest(처음처럼.getId(), image4.getId()));
//            처음처럼과회 = reviewModifyService.save(new AuthMember(마리.getId()), fixture5.toSaveRequest(처음처럼.getId(), image5.getId()));
//            처음처럼과피자2 = reviewModifyService.save(new AuthMember(마리.getId()), fixture6.toSaveRequest(처음처럼.getId(), image3.getId()));
//            처음처럼과피자3 = reviewModifyService.save(new AuthMember(마리.getId()), fixture7.toSaveRequest(처음처럼.getId(), image3.getId()));
//            처음처럼과치킨2 = reviewModifyService.save(new AuthMember(마리.getId()), fixture8.toSaveRequest(처음처럼.getId(), image3.getId()));
        }
    }
}
