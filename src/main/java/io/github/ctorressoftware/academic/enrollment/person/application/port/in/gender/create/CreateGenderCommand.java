package io.github.ctorressoftware.academic.enrollment.person.application.port.in.gender.create;

public record CreateGenderCommand(
        short id,
        String code,
        String description
) {}
