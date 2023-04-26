package com.multi.mariage.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 687029836L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final BooleanPath deleted = createBoolean("deleted");

    public final com.multi.mariage.member.domain.embedded.QEmail email;

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike> likes = this.<com.multi.mariage.like.domain.Like, com.multi.mariage.like.domain.QLike>createList("likes", com.multi.mariage.like.domain.Like.class, com.multi.mariage.like.domain.QLike.class, PathInits.DIRECT2);

    public final com.multi.mariage.member.domain.embedded.QName name;

    public final com.multi.mariage.member.domain.embedded.QNickname nickname;

    public final com.multi.mariage.member.domain.embedded.QPassword password;

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.email = inits.isInitialized("email") ? new com.multi.mariage.member.domain.embedded.QEmail(forProperty("email")) : null;
        this.name = inits.isInitialized("name") ? new com.multi.mariage.member.domain.embedded.QName(forProperty("name")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.multi.mariage.member.domain.embedded.QNickname(forProperty("nickname")) : null;
        this.password = inits.isInitialized("password") ? new com.multi.mariage.member.domain.embedded.QPassword(forProperty("password")) : null;
    }

}

