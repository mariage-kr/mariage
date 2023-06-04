package com.multi.mariage.slope.domain.member;

import com.multi.mariage.slope.domain.member.query.MemberSlopeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSlopeRepository extends JpaRepository<MemberSlope, Long>, MemberSlopeRepositoryCustom {
}
