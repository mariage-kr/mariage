package com.multi.mariage.member.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.domain.embedded.Name;
import com.multi.mariage.member.domain.embedded.Nickname;
import com.multi.mariage.member.domain.embedded.Password;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(MemberSignupRequest request) {
        Email email = Email.of(request.getEmail());

        validateEmailIsNotDuplicated(email);

        Member member = Member.builder()
                .name(Name.of(request.getName()))
                .email(email)
                .password(Password.encrypt(request.getPassword(), passwordEncoder))
                .nickname(Nickname.of(request.getNickname()))
                .birth(request.getBirth())
                .gender(request.getGender())
                .build();

        return memberRepository.save(member);
    }

    private void validateEmailIsNotDuplicated(Email email) {
        if (memberRepository.existsByEmail(email)) {
            throw new MemberException(MemberErrorCode.SIGNUP_INVALID_EMAIL);
        }
    }
}
