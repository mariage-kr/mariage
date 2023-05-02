package com.multi.mariage.auth.service;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.domain.MemberRepository;
import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(Email.of(email))
                .map(this::createUserDetails)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_IS_NOT_EXISTED));
    }

    private UserDetails createUserDetails(Member member) {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(member.getRole().getValue());
        return new User(
                String.valueOf(member.getId()),
                member.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
