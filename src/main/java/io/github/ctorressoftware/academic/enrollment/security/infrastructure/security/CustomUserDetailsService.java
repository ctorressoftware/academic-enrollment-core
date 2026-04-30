package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security;

import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidCredentialsException;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.User;
import io.github.ctorressoftware.academic.enrollment.security.domain.model.Username;
import io.github.ctorressoftware.academic.enrollment.security.domain.ports.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String usernameValue)
            throws UsernameNotFoundException {

        Username username = new Username(usernameValue);

        User user = repository.findByUsername(username).orElseThrow(() ->
                        new InvalidCredentialsException(username));

        return new AuthUser(
                user.getUsername().value(),
                user.getPasswordHash().value(),
                List.of(new SimpleGrantedAuthority("ROLE_STUDENT")),
                user.isActive()
        );
    }
}
