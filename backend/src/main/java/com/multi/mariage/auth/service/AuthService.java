package com.multi.mariage.auth.service;

import com.multi.mariage.auth.domain.AuthRepository;
import com.multi.mariage.auth.domain.RefreshToken;
import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.support.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AuthService {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final AuthRepository authRepository;

    @Transactional
    public TokenResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = request.toAuthentication();

        Authentication authenticate = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        TokenResponse response = tokenProvider.generateTokenResponse(authenticate);

        RefreshToken token = RefreshToken.builder()
                .id(Long.valueOf(authenticate.getName()))
                .value(response.getRefreshToken())
                .build();

        authRepository.save(token);

        return response;
    }
}
