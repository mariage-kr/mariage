package com.multi.mariage.member.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
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
        Member.builder()
                .birth(request.getBirth())
                .email()
                .gender(request.getGender())
                .build();
        memberRepository.save();
        return null;
    }
}
