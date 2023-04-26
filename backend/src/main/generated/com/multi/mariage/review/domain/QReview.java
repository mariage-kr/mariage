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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final StringPath foodContent = createString("foodContent");

    public final NumberPath<Integer> foodScore = createNumber("foodScore", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike> likes = this.<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike>createList("likes", com.multi.mariage.like.domain.Like.class, com.multi.mariage.like.domain.QLike.class, PathInits.DIRECT2);

    public final com.multi.mariage.category.domain.QLowerCategory lowerCategory;

    public final StringPath productContent = createString("productContent");

    public final NumberPath<Integer> productScore = createNumber("productScore", Integer.class);

    public final com.multi.mariage.category.domain.QUpperCategory upperCategory;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lowerCategory = inits.isInitialized("lowerCategory") ? new com.multi.mariage.category.domain.QLowerCategory(forProperty("lowerCategory")) : null;
        this.upperCategory = inits.isInitialized("upperCategory") ? new com.multi.mariage.category.domain.QUpperCategory(forProperty("upperCategory")) : null;
    }

}

