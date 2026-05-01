package io.github.ctorressoftware.academic.enrollment.person.domain.validator;

import java.util.Set;
import java.util.regex.Pattern;

public final class DominicanDniValidator implements DocumentValidator {

    private static final Pattern DNI_PATTERN =
            Pattern.compile("^\\d{11}$");

    private static final Set<String> INVALID_CASES = Set.of(
            "00000000000",
            "11111111111",
            "22222222222",
            "33333333333",
            "44444444444",
            "55555555555",
            "66666666666",
            "77777777777",
            "88888888888",
            "99999999999"
    );

    private static final int[] WEIGHTS = { 1, 2, 1, 2, 1, 2, 1, 2, 1, 2 };

    @Override
    public void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Dni value cannot be blank");
        }

        String normalized = value.replace("-", "");

        if (!DNI_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException("Dni must contain exactly 11 digits");
        }

        if (INVALID_CASES.contains(normalized)) {
            throw new IllegalArgumentException("Invalid dni value");
        }

        if (!hasValidCheckDigit(normalized)) {
            throw new IllegalArgumentException("Invalid dni check digit");
        }
    }

    private boolean hasValidCheckDigit(String value) {
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int digit = Character.digit(value.charAt(i), 10);
            int product = digit * WEIGHTS[i];

            if (product >= 10) {
                product = (product / 10) + (product % 10);
            }

            sum += product;
        }

        int expectedVerifier = (10 - (sum % 10)) % 10;
        int actualVerifier = Character.digit(value.charAt(10), 10);

        return actualVerifier == expectedVerifier;
    }
}
