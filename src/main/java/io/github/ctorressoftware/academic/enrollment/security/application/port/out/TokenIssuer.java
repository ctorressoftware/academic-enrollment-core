package io.github.ctorressoftware.academic.enrollment.security.application.port.out;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;

public interface TokenIssuer {
    String issueAccessToken(User user);
}
