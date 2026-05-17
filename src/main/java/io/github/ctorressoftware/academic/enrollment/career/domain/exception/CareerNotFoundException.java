package io.github.ctorressoftware.academic.enrollment.career.domain.exception;

public class CareerNotFoundException extends RuntimeException {
    public CareerNotFoundException(String code) {
        super("Career not found with code = " + code);
    }
}
