package com.multi.mariage.member.domain;

import com.multi.mariage.member.domain.embedded.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(Email email);
}
