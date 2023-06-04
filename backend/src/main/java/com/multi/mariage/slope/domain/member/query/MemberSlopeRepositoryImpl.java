package com.multi.mariage.slope.domain.member.query;

import com.multi.mariage.slope.domain.member.MemberSlope;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

import static com.multi.mariage.slope.domain.member.QMemberSlope.memberSlope;

public class MemberSlopeRepositoryImpl implements MemberSlopeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public MemberSlopeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<MemberSlope> findByMemberIdAndProductsId(Long memberId, Long thisProductId, Long otherProductId) {
        MemberSlope slope = queryFactory.selectFrom(memberSlope)
                .where(memberSlope.member.id.eq(memberId))
                .where(memberSlope.thisProduct.id.eq(thisProductId))
                .where(memberSlope.otherProduct.id.eq(otherProductId))
                .fetchFirst();

        return Optional.ofNullable(slope);
    }

    @Override
    public Double findAvgDeviationByProductsId(Long thisProductId, Long otherProductId) {
        Double deviation = queryFactory.select(memberSlope.deviation.avg())
                .from(memberSlope)
                .where(memberSlope.thisProduct.id.eq(thisProductId))
                .where(memberSlope.otherProduct.id.eq(otherProductId))
                .fetchFirst();

        return deviation != null ? deviation : 0D;
    }
}
