package com.multi.mariage.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLowerCategory is a Querydsl query type for LowerCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLowerCategory extends EntityPathBase<LowerCategory> {

    private static final long serialVersionUID = 1074110025L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLowerCategory lowerCategory = new QLowerCategory("lowerCategory");

    public final EnumPath<LowerValue> category = createEnum("category", LowerValue.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview> reviews = this.<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview>createList("reviews", com.multi.mariage.review.domain.Review.class, com.multi.mariage.review.domain.QReview.class, PathInits.DIRECT2);

    public final QUpperCategory upperCategory;

    public QLowerCategory(String variable) {
        this(LowerCategory.class, forVariable(variable), INITS);
    }

    public QLowerCategory(Path<? extends LowerCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLowerCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLowerCategory(PathMetadata metadata, PathInits inits) {
        this(LowerCategory.class, metadata, inits);
    }

    public QLowerCategory(Class<? extends LowerCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.upperCategory = inits.isInitialized("upperCategory") ? new QUpperCategory(forProperty("upperCategory")) : null;
    }

}

