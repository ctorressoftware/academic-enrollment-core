package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.TokenIssuer;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenIssuer implements TokenIssuer {
    @Override
    public String issueAccessToken(User user) {
        return "temporary-token.temporary-access-token";
    }
}
