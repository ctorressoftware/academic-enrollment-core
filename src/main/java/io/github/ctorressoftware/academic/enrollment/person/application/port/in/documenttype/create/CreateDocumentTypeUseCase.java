package io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create;

public interface CreateDocumentTypeUseCase {
    CreateDocumentTypeResult save(CreateDocumentTypeCommand command);
}
