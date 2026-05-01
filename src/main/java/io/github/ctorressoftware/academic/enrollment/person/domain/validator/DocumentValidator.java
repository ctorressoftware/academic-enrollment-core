package io.github.ctorressoftware.academic.enrollment.person.domain.validator;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.DocumentType;

public interface DocumentValidator {
    void validate(String value);
}
