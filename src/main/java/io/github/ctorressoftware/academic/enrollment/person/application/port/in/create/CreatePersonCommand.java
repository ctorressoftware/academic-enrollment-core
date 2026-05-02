package io.github.ctorressoftware.academic.enrollment.person.application.port.in.create;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Document;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Email;

public record CreatePersonCommand(
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        Document document,
        int genderId,
        Email email
) {}
