package com.multi.mariage.common.annotation;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodRepository;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.like.domain.LikeRepository;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtagRepository;
import com.multi.mariage.review.domain.ReviewRepository;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.domain.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public abstract class RepositoryTest {
    @Autowired
    protected FoodRepository foodRepository;
    @Autowired
    protected HashtagRepository hashtagRepository;
    @Autowired
    protected MemberRepository memberRepository;
    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected ReviewRepository reviewRepository;
    @Autowired
    protected ReviewHashtagRepository reviewHashtagRepository;
    @Autowired
    protected StorageRepository storageRepository;
    @Autowired
    protected WeatherRepository weatherRepository;
    @Autowired
    protected LikeRepository likeRepository;

    protected Hashtag saveHashtag(String name) {
        Hashtag hashtag = new Hashtag(name);

        return hashtagRepository.save(hashtag);
    }

    protected Member saveMember(MemberFixture memberFixture) {
        Member member = memberFixture.toMember();

        return memberRepository.save(member);
    }

    protected Product saveProduct(ProductFixture productFixture) {
        Product product = productFixture.toProduct();

        Image image = storageRepository.save(new Image(productFixture.getImageName()));
        product.setImage(image);

        return productRepository.save(product);
    }

    protected Review saveReview(ReviewFixture reviewFixture, Member member, Product product, Food food, Image image,
                                Weather weather) {
        Review review = reviewFixture.toReview(member, product, image, weather);
        review.setFoodCategory(food);

        return reviewRepository.save(review);
    }

    protected Image saveImage(ImageFixture imageFixture) {
        Image image = new Image(imageFixture.getOriginFileName());

        return storageRepository.save(image);
    }

    protected Weather saveWeather(WeatherFixture weatherFixture) {
        Weather weather = weatherFixture.toWeather();

        return weatherRepository.save(weather);
    }

    protected Like saveLike(Member member, Review review) {
        Like like = new Like(member, review);

        return likeRepository.save(like);
    }

    protected Food saveFood(ReviewFixture reviewFixture, Product product) {
        Food food = new Food(reviewFixture.getFoodCategory());
        food.setProduct(product);

        return foodRepository.save(food);
    }
}
