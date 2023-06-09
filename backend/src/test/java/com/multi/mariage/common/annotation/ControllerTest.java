package com.multi.mariage.common.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.auth.service.AuthService;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.service.DrinkUpperCategoryService;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.like.service.LikeService;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.service.MemberFindService;
import com.multi.mariage.member.service.MemberModifyService;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.service.ProductModifyService;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.review.service.ReviewModifyService;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


@AutoConfigureRestDocs
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class ControllerTest {
    protected final String BEARER_PREFIX = "Bearer ";
    protected final String AUTHORIZATION = "Authorization";
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected AuthService authService;
    @Autowired
    protected DrinkUpperCategoryService drinkUpperCategoryService;
    @Autowired
    protected MemberFindService memberFindService;
    @Autowired
    protected MemberModifyService memberModifyService;
    @Autowired
    protected ProductModifyService productModifyService;
    @Autowired
    protected ReviewModifyService reviewModifyService;
    @Autowired
    protected StorageService storageService;
    @Autowired
    protected LikeService likeService;
    @Autowired
    protected WeatherService weatherService;

    protected Member saveMember() {
        MemberSignupRequest request = MemberFixture.MARI.toSignupRequest();
        return memberModifyService.signup(request);
    }

    protected String accessToken(MemberFixture memberFixture) {
        LoginRequest request = memberFixture.toLoginRequest();
        return authService.login(request).getAccessToken();
    }

    protected Product saveProduct(ProductFixture productFixture, Long imageId) {
        return productModifyService.save(productFixture.toProductSaveRequest(imageId));
    }

    protected Image saveImage(ImageFixture imageFixture) {
        return storageService.save(imageFixture.toMultipartFile());
    }

    protected ReviewSaveResponse saveReview(ReviewFixture reviewFixture, Long imageId, Long productId, Long memberId) {
        Review review = reviewModifyService.save(new AuthMember(memberId), reviewFixture.toSaveRequest(productId, imageId));
        return new ReviewSaveResponse(review.getId());
    }
    protected void likeReview(AuthMember authMember, LikeSaveRequest request) {
        likeService.save(authMember, request);
    }

    protected Weather saveWeather() {
        return weatherService.findLatestWeather();
    }
}
