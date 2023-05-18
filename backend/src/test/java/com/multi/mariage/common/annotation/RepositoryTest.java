package com.multi.mariage.common.annotation;

import com.multi.mariage.common.fixture.*;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
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
    protected HashtagRepository hashtagRepository;
    @Autowired
    protected MemberRepository memberRepository;
    @Autowired
    protected ProductRepository productRepository;
    @Autowired
    protected ReviewRepository reviewRepository;
    @Autowired
    protected StorageRepository storageRepository;
    @Autowired
    protected WeatherRepository weatherRepository;

    protected Hashtag saveHashtag(HashtagFixture hashtagFixture) {
        Hashtag hashtag = new Hashtag(hashtagFixture.name());

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

    protected Image saveImage(ImageFixture imageFixture) {
        Image image = new Image(imageFixture.getOriginFileName());

        return storageRepository.save(image);
    }

    protected Weather saveWeather(WeatherFixture weatherFixture) {
        Weather weather = weatherFixture.toWeather();

        return weatherRepository.save(weather);
    }
}
