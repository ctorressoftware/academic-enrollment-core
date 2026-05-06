package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAccountResponse(
        Person person,
        String username,
        String accessToken
) {}
