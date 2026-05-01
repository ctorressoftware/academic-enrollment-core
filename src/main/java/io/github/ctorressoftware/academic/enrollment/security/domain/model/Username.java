package io.github.ctorressoftware.academic.enrollment.security.domain.model;

import java.util.Locale;
import java.util.regex.Pattern;

public record Username(String value) {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-z][a-z0-9]{2,}$");
    private static final int USERNAME_MIN_LENGTH = 3;
    private static final int USERNAME_MAX_LENGTH = 15;

    public Username {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Username must not be blank");
        }

        value = value.trim().toLowerCase(Locale.ROOT);

        if (value.length() < USERNAME_MIN_LENGTH || value.length() > USERNAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Username must be between 3 and 15 characters");
        }

        if (!USERNAME_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid username format");
        }
    }
}
