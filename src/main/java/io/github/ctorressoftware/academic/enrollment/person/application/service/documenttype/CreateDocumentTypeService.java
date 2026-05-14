package io.github.ctorressoftware.academic.enrollment.person.application.service.documenttype;

import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeCommand;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeResult;
import io.github.ctorressoftware.academic.enrollment.person.application.port.in.documenttype.create.CreateDocumentTypeUseCase;
import io.github.ctorressoftware.academic.enrollment.person.application.port.out.DocumentTypeRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.documenttype.DocumentType;
import org.springframework.stereotype.Service;

@Service
public class CreateDocumentTypeService implements CreateDocumentTypeUseCase {

    private final DocumentTypeRepository repository;

    public CreateDocumentTypeService(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateDocumentTypeResult create(CreateDocumentTypeCommand command) {
        DocumentType documentType = DocumentType.create(
                command.id(),
                command.code(),
                command.description()
        );

        DocumentType saved = repository.save(documentType);

        return new CreateDocumentTypeResult(saved);    }
}
