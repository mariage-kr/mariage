package com.multi.mariage.common.annotation;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.country.service.CountryService;
import com.multi.mariage.hashtag.service.HashtagService;
import com.multi.mariage.like.domain.LikeRepository;
import com.multi.mariage.like.service.LikeService;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewHashtagService;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import com.multi.mariage.storage.repository.StorageRepository;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.domain.WeatherRepository;
import com.multi.mariage.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class ServiceTest {
    @Autowired
    protected CountryService countryService;
    @Autowired
    protected FoodCategoryService foodCategoryService;
    @Autowired
    protected HashtagService hashtagService;
    @Autowired
    protected MemberFindService memberFindService;
    @Autowired
    protected MemberModifyService memberModifyService;
    @Autowired
    protected ProductFindService productFindService;
    @Autowired
    protected ProductModifyService productModifyService;
    @Autowired
    protected ReviewModifyService reviewModifyService;
    @Autowired
    protected ReviewHashtagService reviewHashtagService;
    @Autowired
    protected StorageService storageService;
    @Autowired
    protected WeatherService weatherService;
    @Autowired
    protected LikeService likeService;

    /* TODO: 2023/05/18 추후 FindService 로 수정 */
    @Autowired
    protected ReviewRepository reviewRepository;
    @Autowired
    protected StorageRepository storageRepository;
    @Autowired
    protected WeatherRepository weatherRepository;
    @Autowired
    protected MemberRepository memberRepository;
    @Autowired
    protected LikeRepository likeRepository;

    protected Member signup(MemberFixture memberFixture) {
        return memberModifyService.signup(memberFixture.toSignupRequest());
    }

    protected Product saveProduct(ProductFixture productFixture, Long imageId) {
        return productModifyService.save(productFixture.toProductSaveRequest(imageId));
    }

    protected ImageSavedResponse saveImage(ImageFixture imageFixture) {
        MockMultipartFile file = imageFixture.toMultipartFile();
        return storageService.saveFile(file);
    }

    protected ReviewSaveResponse saveReview(ReviewFixture reviewFixture,
                                            Long memberId,
                                            Long productId,
                                            Long foodImageId) {
        return reviewModifyService.save(new AuthMember(memberId), reviewFixture.toSaveRequest(productId, foodImageId));
    }

    protected int findReviewLike(Long reviewId) {
        return likeRepository.countByReviewId(reviewId);
    }
}
