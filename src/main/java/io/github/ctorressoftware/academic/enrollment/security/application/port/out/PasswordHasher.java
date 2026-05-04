package io.github.ctorressoftware.academic.enrollment.security.domain.ports;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.PasswordHash;

public interface PasswordHasher {
    PasswordHash hash(String rawPassword);
    boolean matches(String rawPassword, PasswordHash passwordHash);
}
