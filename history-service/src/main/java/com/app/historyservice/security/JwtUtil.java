package com.app.historyservice.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Shared JWT validator — same SECRET as auth-service.
 * Only validates tokens; does NOT generate them (generation is auth-service's job).
 * Secret is injected from application.properties / JWT_SECRET env var.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret:mysecretkeymysecretkeymysecretkey}")
    private String secret;

    private Key getKey() { return Keys.hmacShaKeyFor(secret.getBytes()); }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
