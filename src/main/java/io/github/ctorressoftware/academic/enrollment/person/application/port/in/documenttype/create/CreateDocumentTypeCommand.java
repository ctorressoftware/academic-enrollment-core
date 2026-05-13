package io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create;

public record CreateDocumentTypeCommand(
        short id,
        String code,
        String description
) {}
