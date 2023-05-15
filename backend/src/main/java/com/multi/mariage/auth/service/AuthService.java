package com.multi.mariage.auth.service;

import com.multi.mariage.auth.domain.AuthRepository;
import com.multi.mariage.auth.domain.RefreshToken;
import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.auth.dto.request.LoginRequest;
import com.multi.mariage.auth.dto.request.ReissueRequest;
import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.exception.AuthErrorCode;
import com.multi.mariage.auth.exception.AuthException;
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

    @Transactional
    public void logout(AuthMember authMember) {
        authRepository.deleteById(authMember.getId());
    }

    @Transactional
    public TokenResponse reissue(ReissueRequest request) {
        if (!tokenProvider.validateToken(request.getRefreshToken())) {
            throw new AuthException(AuthErrorCode.REFRESH_TOKEN_MUST_BE_VALID);
        }

        Authentication authentication = tokenProvider.getAuthentication(request.getAccessToken());

        Long id = Long.valueOf(authentication.getName());
        RefreshToken refreshToken = authRepository.findById(id)
                .orElseThrow(() -> new AuthException(AuthErrorCode.MEMBER_IS_ALREADY_LOGOUT));

        if (!refreshToken.getValue().equals(request.getRefreshToken())) {
            throw new AuthException(AuthErrorCode.TOKEN_MEMBER_INFORMATION_IS_NOT_SAME);
        }

        TokenResponse response = tokenProvider.generateTokenResponse(authentication);

        RefreshToken newRefreshToken = RefreshToken.builder()
                .id(id)
                .value(response.getRefreshToken())
                .build();

        authRepository.save(newRefreshToken);

        return response;
    }
}
