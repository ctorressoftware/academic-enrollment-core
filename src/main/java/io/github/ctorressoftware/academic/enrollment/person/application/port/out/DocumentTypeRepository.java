package io.github.ctorressoftware.academic.enrollment.person.application.port.out;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.documenttype.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeRepository {
    DocumentType save(DocumentType documentType);
    Optional<DocumentType> getByCode(String code);
    List<DocumentType> getAllByCodeAndIsActive(String code);
    DocumentType update(DocumentType documentType);
    void remove(short id);
}
