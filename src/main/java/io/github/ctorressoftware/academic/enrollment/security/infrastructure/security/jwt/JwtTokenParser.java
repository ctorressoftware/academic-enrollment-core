package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security.jwt;

import io.github.ctorressoftware.academic.enrollment.security.application.port.out.TokenParser;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class JwtTokenParser implements TokenParser {

    private final SecretKey secretKey;

    public JwtTokenParser(JwtConfig config) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(config.getSecretKey()));
    }

    @Override
    public Jws<Claims> parse(String jwt) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(jwt);
    }
}

