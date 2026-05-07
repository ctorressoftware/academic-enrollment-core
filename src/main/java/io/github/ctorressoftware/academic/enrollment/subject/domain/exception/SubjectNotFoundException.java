package io.github.ctorressoftware.academic.enrollment.subject.domain.exception;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(String code) {
        super("Subject not found for code: " + code);
    }
}
