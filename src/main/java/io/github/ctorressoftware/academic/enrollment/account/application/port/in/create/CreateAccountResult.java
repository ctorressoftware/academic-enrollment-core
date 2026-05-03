package io.github.ctorressoftware.academic.enrollment.account.application.port.in;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;

public record CreateAccountResult(
        Person person,
        String username,
        String accessToken
) {}
