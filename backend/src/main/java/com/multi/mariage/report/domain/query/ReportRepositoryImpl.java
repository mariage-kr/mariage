package com.multi.mariage.report.domain.query;

import com.multi.mariage.review.domain.QReview;
import com.multi.mariage.review.domain.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import static com.multi.mariage.report.domain.QReport.report;

public class ReportRepositoryImpl implements ReportRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReportRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Long findCountByReview(Review review) {
        return queryFactory.select(report.count())
                .from(report)
                .join(report.review, QReview.review)
                .where(report.review.eq(review))
                .fetchFirst();
    }
}
