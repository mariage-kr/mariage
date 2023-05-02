package com.multi.mariage.auth.support;

import com.multi.mariage.auth.dto.response.TokenResponse;
import com.multi.mariage.auth.exception.AuthErrorCode;
import com.multi.mariage.auth.exception.AuthException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TokenProvider {
    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000L * 60 * 60;
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000L * 60 * 60 * 24 * 7;

    private final Key key;

    public TokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenResponse generateTokenResponse(Authentication auth) {
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date().getTime());

        String accessToken = Jwts.builder()
                .setSubject(auth.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .setExpiration(new Date(now + ACCESS_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        return TokenResponse.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpiresIn(new Date(now + ACCESS_TOKEN_EXPIRE_TIME).getTime())
                .build();
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = paresClaims(accessToken);

        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new AuthException(AuthErrorCode.TOKEN_WITHOUT_AUTHORIZATION_INFORMATION);
        }

        List<SimpleGrantedAuthority> authorities = Arrays.stream(
                        claims.get(AUTHORITIES_KEY)
                                .toString()
                                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();

        UserDetails principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new AuthException(AuthErrorCode.JWT_SIGNATURE_MUST_BE_VALID);
        } catch (ExpiredJwtException e) {
            throw new AuthException(AuthErrorCode.JWT_MUST_BE_NOT_EXPIRED);
        } catch (UnsupportedJwtException e) {
            throw new AuthException(AuthErrorCode.JWT_NOT_SUPPORT);
        } catch (IllegalArgumentException e) {
            throw new AuthException(AuthErrorCode.JWT_BE_MUST_VALID);
        }
    }

    private Claims paresClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public String getPayload(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
