package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAccountRequest(
        @NotBlank(message = "FirstName cannot be blank")
        String firstName,

        @Size(min = 1, message = "MiddleName can be null, but not an empty value")
        String middleName,

        @NotBlank(message = "LastName cannot be blank")
        String lastName,

        @NotBlank(message = "SecondLastName cannot be blank")
        String secondLastName,

        @Size(min = 1, message = "DocumentTypeId only can be a value higher than zero")
        short documentTypeId,

        @NotBlank(message = "DocumentNumber cannot be blank")
        String documentNumber,

        @Size(min = 1, message = "GenderId only can be a value higher than zero")
        short genderId,

        @NotBlank(message = "Email cannot be blank")
        String email,

        @NotBlank(message = "Username cannot be blank")
        String username,

        @NotBlank(message = "Password cannot be blank")
        String password
) {}
