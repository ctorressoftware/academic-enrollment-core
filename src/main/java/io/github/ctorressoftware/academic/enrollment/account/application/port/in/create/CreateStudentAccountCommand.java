package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create;

import java.util.UUID;

public record CreateStudentAccountCommand(
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        UUID careerId,
        short documentTypeId,
        String documentNumber,
        short genderId,
        String email,
        String username,
        String password
) implements CreateAccountCommand {}