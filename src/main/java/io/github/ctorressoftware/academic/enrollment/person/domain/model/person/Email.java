package io.github.ctorressoftware.academic.enrollment.person.domain.model;

import java.util.regex.Pattern;

public record Email(String value) {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public Email {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email must not be blank");
        }

        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
    }
}
