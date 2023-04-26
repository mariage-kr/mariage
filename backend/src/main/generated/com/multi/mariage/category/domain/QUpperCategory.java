package com.multi.mariage.category.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUpperCategory is a Querydsl query type for UpperCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUpperCategory extends EntityPathBase<UpperCategory> {

    private static final long serialVersionUID = -1743676694L;

    public static final QUpperCategory upperCategory = new QUpperCategory("upperCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<LowerCategory, QLowerCategory> lowerCategories = this.<LowerCategory, QLowerCategory>createList("lowerCategories", LowerCategory.class, QLowerCategory.class, PathInits.DIRECT2);

    public final ListPath<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview> reviews = this.<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview>createList("reviews", com.multi.mariage.review.domain.Review.class, com.multi.mariage.review.domain.QReview.class, PathInits.DIRECT2);

    public QUpperCategory(String variable) {
        super(UpperCategory.class, forVariable(variable));
    }

    public QUpperCategory(Path<? extends UpperCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUpperCategory(PathMetadata metadata) {
        super(UpperCategory.class, metadata);
    }

}

