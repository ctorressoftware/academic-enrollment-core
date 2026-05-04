package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.application.port.out.TokenIssuer;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenIssuer implements TokenIssuer {
    private final SecretKey secretKey;
    private final String issuer;
    private final Duration duration;
    private final Clock clock;

    public JwtTokenIssuer(JwtConfig config, Clock clock) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(config.getSecretKey()));
        this.issuer = config.getIssuer();
        this.duration = Duration.ofMinutes(config.getAccessMinutes());
        this.clock = clock;
    }

    @Override
    public String issueAccessToken(User user) {

        Instant now = Instant.now(clock);

        // TODO: add accountType to determine roles
        Map<String, String> claims = Map.of(
                "userId", user.getId().toString(),
                "personId", user.getPersonId().toString(),
                "username", user.getUsername().value()
        );

        return Jwts.builder()
                .subject(user.getId().toString())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(duration)))
                .claims(claims)
                .signWith(secretKey, Jwts.SIG.HS512)
                .compact();
    }
}
