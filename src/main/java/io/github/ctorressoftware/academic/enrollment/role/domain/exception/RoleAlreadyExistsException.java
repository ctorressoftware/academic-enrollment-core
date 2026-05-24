package io.github.ctorressoftware.academic.enrollment.role.domain.exception;

public class RoleAlreadyExistsException extends RuntimeException {
    public RoleAlreadyExistsException(String code) {
        super("Role code already exists. Code = " + code);
    }
}
