package io.github.ctorressoftware.academic.enrollment.account.application.port.in;

public record CreateAccountCommand(
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        short documentTypeId,
        String documentNumber,
        short genderId,
        String email,
        String username,
        String password
) {
}
