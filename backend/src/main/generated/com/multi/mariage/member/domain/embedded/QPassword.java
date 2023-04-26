package com.multi.mariage.member.domain.embedded;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPassword is a Querydsl query type for Password
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPassword extends BeanPath<Password> {

    private static final long serialVersionUID = 1191140045L;

    public static final QPassword password = new QPassword("password");

    public final StringPath value = createString("value");

    public QPassword(String variable) {
        super(Password.class, forVariable(variable));
    }

    public QPassword(Path<? extends Password> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPassword(PathMetadata metadata) {
        super(Password.class, metadata);
    }

}

