package com.multi.mariage.auth.annotation;

import com.multi.mariage.auth.dto.AuthMember;
import com.multi.mariage.auth.support.TokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AuthenticatedArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String BEARER_TYPE = "Bearer ";
    private final TokenProvider tokenProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasParameterAnnotation = parameter.hasParameterAnnotation(Authenticated.class);
        boolean hasLongType = AuthMember.class.isAssignableFrom(parameter.getParameterType());
        return hasParameterAnnotation && hasLongType;
    }

    @Override
    public AuthMember resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String authorization = Objects.requireNonNull(request)
                .getHeader(HEADER_AUTHORIZATION);
        String token = authorization.substring(BEARER_TYPE.length()).trim();
        Long memberId = tokenProvider.getPayload(token);
        return new AuthMember(memberId);
    }
}
