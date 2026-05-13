package io.github.ctorressoftware.academic.enrollment.person.domain.model;

import io.github.ctorressoftware.academic.enrollment.person.domain.validator.DocumentValidatorFactory;

public record Document(DocumentTypeCode type, String value) {

    public Document {
         DocumentValidatorFactory
                 .getValidator(type)
                 .validate(value);
    }
}
