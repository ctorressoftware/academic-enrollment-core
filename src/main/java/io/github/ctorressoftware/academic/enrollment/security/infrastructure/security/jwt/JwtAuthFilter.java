package io.github.ctorressoftware.academic.enrollment.security.infrastructure.security.jwt;

import io.github.ctorressoftware.academic.enrollment.security.application.port.out.TokenParser;
import io.github.ctorressoftware.academic.enrollment.security.application.port.out.UserDetailsLoader;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.AuthTokenExpiredException;
import io.github.ctorressoftware.academic.enrollment.security.domain.exception.InvalidAuthTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final TokenParser parser;
    private final UserDetailsLoader uds;

    public JwtAuthFilter(TokenParser parser, UserDetailsLoader uds) {
        this.parser = parser;
        this.uds = uds;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        var header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null && header.startsWith("Bearer ")) {

            var token = header.substring(7);

            try {
                Jws<Claims> claims = parser.parse(token);
                String userId = claims.getPayload().getSubject();
                var userDetails = uds.loadUserById(userId);

                var auth = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (ExpiredJwtException e) {
                throw new AuthTokenExpiredException(e);
            } catch (JwtException e) {
                throw new InvalidAuthTokenException(e);
            }
        }

        doFilter(request, response, filterChain);
    }
}
