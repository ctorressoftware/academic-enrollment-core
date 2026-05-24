package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security;

import io.github.ctorressoftware.academic.enrollment.role.application.port.out.RoleRepository;
import io.github.ctorressoftware.academic.enrollment.role.domain.exception.RoleNotFoundException;
import io.github.ctorressoftware.academic.enrollment.role.domain.model.Role;
import io.github.ctorressoftware.academic.enrollment.security.application.port.out.UserDetailsLoader;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidCredentialsException;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.application.port.out.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsLoader {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public CustomUserDetailsService(
            UserRepository userRepository,
            RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String usernameValue)
            throws UsernameNotFoundException {

        Username username = new Username(usernameValue);

        User user = userRepository.findByUsername(username).orElseThrow(() ->
                        new InvalidCredentialsException(username));

        Role role = roleRepository.findById(user.getRoleId())
                .orElseThrow(() -> new RoleNotFoundException(user.getRoleId()));

        return new AuthUser(
                user.getUsername().value(),
                user.getPasswordHash().value(),
                List.of(new SimpleGrantedAuthority("ROLE_" + role.getCode())),
                user.isActive()
        );
    }

    public UserDetails loadUserById(@NonNull String userId)
            throws UsernameNotFoundException {

        UUID id = UUID.fromString(Objects.requireNonNull(userId));

        User user = userRepository.findById(id)
                .orElseThrow(() -> new InvalidCredentialsException(id));

        Role role = roleRepository.findById(user.getRoleId())
                .orElseThrow(() -> new RoleNotFoundException(user.getRoleId()));

        return new AuthUser(
                user.getUsername().value(),
                user.getPasswordHash().value(),
                List.of(new SimpleGrantedAuthority("ROLE_" + role.getCode())),
                user.isActive()
        );
    }
}
