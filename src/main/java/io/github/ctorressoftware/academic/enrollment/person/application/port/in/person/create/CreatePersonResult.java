package io.github.ctorressoftware.academic.enrollment.person.application.port.in.create;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Person;

public record CreatePersonResult(
        Person person
) {}
