package io.github.ctorressoftware.academic.enrollment.role.domain.exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String code) {
        super("Role not found with code: " + code);
    }
}
