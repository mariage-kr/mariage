package com.multi.mariage.product.domain.query;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.condition.RecommendCond;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.weather.domain.Weather;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static com.multi.mariage.category.domain.QFood.food;
import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.storage.domain.QImage.image;
import static com.multi.mariage.weather.domain.QWeather.weather;

@Slf4j
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private static final String WEEK = "week";
    private static final String MONTH = "month";
    private static final String RATE = "rate";
    private static final String REVIEW_COUNT = "count";
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> findRecommendProductsByWeather(int size, Weather latestWeather) {
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
    public List<Product> findRecommendProductsByDate(RecommendCond cond) {
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
        if (cond.equalsIgnoreCase(WEEK)) {
            return weather.date.between(now.minusWeeks(1), now);
        }
        if (cond.equalsIgnoreCase(MONTH)) {
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

    @Override
    public List<Product> findProductsByFilter(ProductFindByFilterRequest cond) {
        List<Long> productIds = queryFactory.select(product.id)
                .from(product)
                .leftJoin(product.reviews, review)
                .where(hasSearch(cond.getSearch()))
                .where(equalsUpperCategory(cond.getUpperCategory()))
                .where(equalsLowerCategory(cond.getLowerCategory()))
                .where(betweenRangeLevel(cond.getMinLevel(), cond.getMaxLevel()))
                .where(betweenRangeRate(cond.getMinRate(), cond.getMaxRate()))
                .orderBy(sortOption(cond.getSort()))
                .offset(getOffset(cond.getPageNumber(), cond.getPageSize()))
                .limit(cond.getPageSize())
                .fetch();

        return queryFactory.selectFrom(product)
                .join(product.image, image).fetchJoin()
                .leftJoin(product.reviews, review).fetchJoin()
                .leftJoin(product.foods, food).fetchJoin()
                .where(product.id.in(productIds))
                .orderBy(sortOption(cond.getSort()))
                .fetch();
    }

    @Override
    public Long countProductWithFilter(ProductFindByFilterRequest cond) {
        return queryFactory.select(product.count())
                .from(product)
                .where(equalsUpperCategory(cond.getUpperCategory()))
                .where(equalsLowerCategory(cond.getLowerCategory()))
                .where(betweenRangeLevel(cond.getMinLevel(), cond.getMaxLevel()))
                .where(betweenRangeRate(cond.getMinRate(), cond.getMaxRate()))
                .where(hasSearch(cond.getSearch()))
                .fetchFirst();
    }

    private BooleanExpression equalsUpperCategory(DrinkUpperCategory upperCategory) {
        return upperCategory != null ? product.upperCategory.eq(upperCategory) : null;
    }

    private BooleanExpression equalsLowerCategory(DrinkLowerCategory lowerCategory) {
        return lowerCategory != null ? product.lowerCategory.eq(lowerCategory) : null;
    }

    private BooleanExpression betweenRangeLevel(int minLevel, int maxLevel) {
        return product.level.value.between(minLevel, maxLevel);
    }

    private BooleanExpression betweenRangeRate(int minRate, int maxRate) {
        return product.avgReviewRate.between(minRate, maxRate);
    }

    private BooleanExpression hasSearch(String search) {
        return StringUtils.hasText(search) ? product.name.value.contains(search) : null;
    }

    private OrderSpecifier<? extends Number> sortOption(String sort) {
        if (sort.equalsIgnoreCase(REVIEW_COUNT)) {
            return product.reviews.size().desc();
        }
        if (sort.equalsIgnoreCase(RATE)) {
            return product.avgReviewRate.desc();
        }
        return null;
    }

    private int getOffset(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }
}
