package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.person.application.port.out.DocumentTypeRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.documenttype.DocumentType;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.DocumentTypeEntity;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository.SpringDataDocumentTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaDocumentTypeRepositoryAdapter implements DocumentTypeRepository {

    private final SpringDataDocumentTypeRepository repository;

    public JpaDocumentTypeRepositoryAdapter(SpringDataDocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType save(DocumentType documentType) {
        DocumentTypeEntity saved = repository.save(toEntity(documentType));
        return toDomain(saved);
    }

    @Override
    public Optional<DocumentType> getByCode(String code) {
        return repository.getByCode(code);
    }

    @Override
    public List<DocumentType> getAllByCodeAndIsActive(String code) {
        List<DocumentTypeEntity> documentTypeEntities =
                repository.getAllByCodeAndActiveIsTrue(code);
        return toDomain(documentTypeEntities);
    }


    private List<DocumentType> toDomain(List<DocumentTypeEntity> entities) {
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public DocumentType update(DocumentType documentType) {

        DocumentTypeEntity entity = repository.update(
                documentType.getId(),
                documentType.getCode(),
                documentType.getDescription(),
                documentType.isActive(),
                documentType.getUpdatedAt()
        );

        return toDomain(entity);
    }

    @Override
    public void remove(short id) {
        repository.removeById(id);
    }

    private DocumentTypeEntity toEntity(DocumentType documentType) {
        DocumentTypeEntity entity = new DocumentTypeEntity();
        entity.setId(documentType.getId());
        entity.setCode(documentType.getCode());
        entity.setDescription(documentType.getDescription());
        entity.setActive(documentType.isActive());
        entity.setCreatedAt(documentType.getCreatedAt());
        entity.setUpdatedAt(documentType.getUpdatedAt());
        return entity;
    }

    private DocumentType toDomain(DocumentTypeEntity entity) {
        return DocumentType.restore(
                entity.getId(),
                entity.getCode(),
                entity.getDescription(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

}
