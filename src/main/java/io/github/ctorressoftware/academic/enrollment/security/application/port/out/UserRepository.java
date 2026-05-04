package io.github.ctorressoftware.academic.enrollment.security.application.port.out;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    boolean existsByUsername(Username username);
    Optional<User> findByUsername(Username username);
    Optional<User> findById(UUID userId);
    User save(User user);
}
