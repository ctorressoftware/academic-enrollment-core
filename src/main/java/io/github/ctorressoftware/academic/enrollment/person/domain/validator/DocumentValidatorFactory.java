package io.github.ctorressoftware.academic.enrollment.person.domain.validator;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.DocumentType;

public class DocumentValidatorFactory {
    private static final DominicanDniValidator DNI_VALIDATOR = new DominicanDniValidator();
    private static final PassportValidator PASSPORT_VALIDATOR = new PassportValidator();

    public static DocumentValidator getValidator(DocumentType type) {

        if (type == null) {
            throw new IllegalArgumentException("Document type cannot be null");
        }

        return switch (type) {
            case DNI -> DNI_VALIDATOR;
            case PASSPORT -> PASSPORT_VALIDATOR;
        };
    }

}
