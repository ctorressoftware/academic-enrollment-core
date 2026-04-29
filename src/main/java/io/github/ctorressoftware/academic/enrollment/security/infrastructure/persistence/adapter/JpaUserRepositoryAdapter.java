package io.github.ctorressoftware.academic.enrollment.security.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.security.domain.model.PasswordHash;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.UserRepository;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.persistence.entity.UserEntity;
import io.github.ctorressoftware.academic.enrollment.security.infrastructure.persistence.repository.SpringDataUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class JpaUserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByUsername(Username username) {
        return repository.existsByUsername(username.value());
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return repository.findByUsername(username.value())
                .map(this::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity saved = repository.save(toEntity(user));
        return toDomain(saved);
    }

    private User toDomain(UserEntity entity) {
        return User.create(
                entity.getPersonId(),
                new Username(entity.getUsername()),
                new PasswordHash(entity.getPasswordHash())
        );
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setPersonId(user.getPersonId());
        entity.setUsername(user.getUsername().value());
        entity.setPasswordHash(user.getPasswordHash().value());
        entity.setActive(user.isActive());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }
}
