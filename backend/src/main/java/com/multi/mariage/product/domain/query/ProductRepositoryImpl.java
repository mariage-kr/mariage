package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.RecommendCond;
import com.multi.mariage.weather.domain.Weather;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.storage.domain.QImage.image;
import static com.multi.mariage.weather.domain.QWeather.weather;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private static final String WEEK = "week".toLowerCase();
    private static final String MONTH = "month".toLowerCase();
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return queryFactory.selectFrom(product)
                .where(product.name.value.contains(name))
                .fetch();
    }

    @Override
    public List<Product> findWeather(int size, Weather latestWeather) {
        List<Long> productIdsByWeather = queryFactory.select(product.id)
                .from(product)
                .join(product.reviews, review)
                .join(review.weather, weather)
                .where(weather.value.eq(latestWeather.getValue()))
                .groupBy(product.id)
                .orderBy(product.reviews.size().desc())
                .offset(0)
                .limit(size)
                .fetch();

        return getRecommendProducts(productIdsByWeather);
    }

    /* https://velog.io/@cksdnr066/WARN-firstResultmaxResults-specified-with-collection-fetch-applying-in-memory */
    @Override
    public List<Product> findDate(RecommendCond cond) {
        List<Long> productIds = queryFactory.select(product.id)
                .from(product)
                .join(product.reviews, review)
                .join(review.weather, weather)
                .where(betweenRangeDate(cond.getOption()))
                .groupBy(product.id)
                .orderBy(product.reviews.size().desc())
                .offset(0)
                .limit(cond.getSize())
                .fetch();

        return getRecommendProducts(productIds);
    }

    private BooleanExpression betweenRangeDate(String cond) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        if (cond.equals(WEEK)) {
            return weather.date.between(now.minusWeeks(1), now);
        }
        if (cond.equals(MONTH)) {
            return weather.date.between(now.minusMonths(1), now);
        }
        return null;
    }

    private List<Product> getRecommendProducts(List<Long> productIds) {
        return queryFactory.selectFrom(product)
                .join(product.image, image).fetchJoin()
                .join(product.reviews, review).fetchJoin()
                .where(product.id.in(productIds))
                .orderBy(product.name.value.asc())
                .fetch();
    }
}
