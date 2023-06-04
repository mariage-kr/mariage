package com.multi.mariage.slope.domain.member.query;

import com.multi.mariage.slope.domain.member.MemberSlope;

import java.util.List;
import java.util.Optional;

public interface MemberSlopeRepositoryCustom {
    /**
     * 제품의 식별 번호로 해당 객체를 조회한다.
     *
     * @param memberId       유저 식별 번호
     * @param thisProductId  제품 식별 번호
     * @param otherProductId 편차를 구할 제품 식별 번호
     * @return Slope
     */
    Optional<MemberSlope> findByMemberIdAndProductsId(Long memberId, Long thisProductId, Long otherProductId);

    Double findAvgDeviationByProductsId(Long thisProductId, Long otherProductId);

    List<MemberSlope> findByMemberId(Long memberId);
}
