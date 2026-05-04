package io.github.ctorressoftware.academic.enrollment.security.application.port.out;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public interface TokenParser {
    Jws<Claims> parse(String jwt);
}
