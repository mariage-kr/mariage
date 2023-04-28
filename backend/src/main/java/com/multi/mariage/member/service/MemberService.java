package com.multi.mariage.member.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(MemberSignupRequest request) {
        Member member = Member.builder()
                .birth(request.getBirth())
                .email(Email.of(request.getEmail()))
                .gender(request.getGender())
                .build();
        return memberRepository.save(member);
    }
}
