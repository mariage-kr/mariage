package com.multi.mariage.country.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCountry is a Querydsl query type for Country
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCountry extends EntityPathBase<Country> {

    private static final long serialVersionUID = 266513952L;

    public static final QCountry country = new QCountry("country");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Value> name = createEnum("name", Value.class);

    public final ListPath<com.multi.mariage.product.domain.Product, com.multi.mariage.product.domain.QProduct> products = this.<com.multi.mariage.product.domain.Product, com.multi.mariage.product.domain.QProduct>createList("products", com.multi.mariage.product.domain.Product.class, com.multi.mariage.product.domain.QProduct.class, PathInits.DIRECT2);

    public QCountry(String variable) {
        super(Country.class, forVariable(variable));
    }

    public QCountry(Path<? extends Country> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCountry(PathMetadata metadata) {
        super(Country.class, metadata);
    }

}

