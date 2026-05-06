package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;

public record CreateAccountResult(
        Person person,
        String username,
        String accessToken
) {}
