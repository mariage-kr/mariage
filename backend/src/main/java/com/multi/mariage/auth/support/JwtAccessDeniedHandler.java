package com.multi.mariage.auth.support;

import com.multi.mariage.auth.exception.AuthErrorCode;
import com.multi.mariage.auth.exception.AuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        throw new AuthException(AuthErrorCode.AUTH_PERMISSION_TO_ACCESS_THE_REQUEST_ROLE);
    }
}
