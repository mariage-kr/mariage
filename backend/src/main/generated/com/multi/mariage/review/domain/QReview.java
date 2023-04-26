package com.multi.mariage.review.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1766329528L;

    public static final QReview review = new QReview("review");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath foodContent = createString("foodContent");

    public final NumberPath<Integer> foodScore = createNumber("foodScore", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike> likes = this.<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike>createList("likes", com.multi.mariage.like.domain.Like.class, com.multi.mariage.like.domain.QLike.class, PathInits.DIRECT2);

    public final StringPath productContent = createString("productContent");

    public final NumberPath<Integer> productScore = createNumber("productScore", Integer.class);

    public QReview(String variable) {
        super(Review.class, forVariable(variable));
    }

    public QReview(Path<? extends Review> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(Review.class, metadata);
    }

}

