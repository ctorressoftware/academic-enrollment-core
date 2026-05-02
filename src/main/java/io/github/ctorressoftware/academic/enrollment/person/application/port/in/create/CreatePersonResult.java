package io.github.ctorressoftware.academic.enrollment.person.application.port.in.create;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;

public record CreatePersonResult(
        Person person
) {}
