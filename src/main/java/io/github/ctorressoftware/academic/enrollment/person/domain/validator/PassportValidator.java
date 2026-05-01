package io.github.ctorressoftware.academic.enrollment.person.domain.validator;

import java.util.regex.Pattern;

public final class PassportValidator implements DocumentValidator {

    private static final Pattern PASSPORT_PATTERN =
            Pattern.compile("^[a-zA-Z0-9]{6,20}$");

    @Override
    public void validate(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Passport cannot be blank");
        }

        if (!PASSPORT_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid passport format");
        }
    }
}
