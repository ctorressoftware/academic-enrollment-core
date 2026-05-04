package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security.jwt;

import io.github.ctorressoftware.academic.enrollment.security.domain.exception.AuthTokenExpiredException;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidAuthTokenException;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    private final ObjectMapper objectMapper;

    public JwtAuthenticationEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(
            @NonNull HttpServletRequest request,
            HttpServletResponse response,
            @NonNull AuthenticationException authException
    ) throws IOException, ServletException {

        if (response.isCommitted()) return;

        AuthError error = resolveError(authException);

        log.warn("Authentication failed. code={}, exception={}", error.code(), error.message());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        var body = ApiResponse.error(error.code(), error.message(), null);

        objectMapper.writeValue(response.getWriter(), body);
    }

    private AuthError resolveError(AuthenticationException exception) {
        return switch (exception) {
            case AuthTokenExpiredException ignored ->
                new AuthError("AUTH_TOKEN_EXPIRED", "Authentication token has expired");
            case InvalidAuthTokenException ignored ->
                    new AuthError("INVALID_AUTH_TOKEN", "Invalid authentication token");
            default -> new AuthError("UNAUTHORIZED", "Authentication is required");
        };
    }
}
