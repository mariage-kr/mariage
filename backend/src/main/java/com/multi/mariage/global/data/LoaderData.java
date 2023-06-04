package com.multi.mariage.global.data;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.global.data.Fixture.MemberFixture;
import com.multi.mariage.global.data.Fixture.ProductFixture;
import com.multi.mariage.global.data.Fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.multi.mariage.global.data.Fixture.ProductFixture.values;


@RequiredArgsConstructor
@Component
@Profile("dev")
public class LoaderData {
    private static final List<Member> members = new ArrayList<>();
    private static final List<Product> products = new ArrayList<>();
    private static final List<Review> reviews = new ArrayList<>();
    private final InitMemberService memberService;
    private final InitProductService productService;
    private final InitReviewService reviewService;

    @PostConstruct
    public void init() {
//        memberService.init();
//        productService.init();
//        reviewService.init();
    }

    @RequiredArgsConstructor
    @Component
    static class InitMemberService {
        private final MemberModifyService memberService;

        public void init() {
            for (MemberFixture memberFixture : MemberFixture.values()) {
                members.add(signupMember(memberFixture));
            }
        }

        private Member signupMember(MemberFixture memberFixture) {
            return memberService.signup(memberFixture.toSignupRequest());
        }
    }

    @RequiredArgsConstructor
    @Component
    static class InitProductService {
        private final ProductModifyService productModifyService;
        private final StorageRepository storageRepository;

        public void init() {
            for (ProductFixture productFixture : values()) {
                products.add(saveProduct(productFixture));
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

        public void init() {
            for (ReviewFixture reviewFixture : ReviewFixture.values()) {
                reviews.add(saveReview(reviewFixture));
            }
        }

        private Review saveReview(ReviewFixture reviewFixture) {
            AuthMember authMember = getAuthMember(reviewFixture.getMemberEmail());
            ReviewSaveRequest request = getSaveRequest(reviewFixture);

            return reviewModifyService.save(Objects.requireNonNull(authMember), request);
        }

        private AuthMember getAuthMember(String email) {
            for (Member member : members) {
                if (member.getEmail().equals(email)) {
                    return new AuthMember(member.getId());
                }
            }
            return null;
        }

        private ReviewSaveRequest getSaveRequest(ReviewFixture reviewFixture) {
            Long productId = getProductId(reviewFixture.getProductName());
            Long imageId = getImageId(reviewFixture.getFoodImagePath());

            return reviewFixture.from(productId, imageId);
        }

        private Long getProductId(String productName) {
            for (Product product : products) {
                if (product.getName().equals(productName)) {
                    return product.getId();
                }
            }
            return null;
        }

        private Long getImageId(String imagePath) {
            Image savedImage = storageRepository.save(new Image(imagePath));
            return savedImage.getId();
        }
    }
}
