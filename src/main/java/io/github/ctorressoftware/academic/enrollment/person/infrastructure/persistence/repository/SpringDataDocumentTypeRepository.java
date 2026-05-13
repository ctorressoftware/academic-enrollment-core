package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.documenttype.DocumentType;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataDocumentTypeRepository
        extends JpaRepository<DocumentTypeEntity, Short> {
    void removeById(Short id);

    @Modifying
    @Query("""
            update document_type set
              code = :code,
              description = :description,
              active = :active,
              updatedAt = :updatedAt
              where id = :id
            """)
    DocumentTypeEntity update(
            @Param("id") short id,
            @Param("code") String code,
            @Param("description") String description,
            @Param("active") boolean active,
            @Param("updatedAt") Instant updatedAt
    );

    List<DocumentTypeEntity> getAllByCodeAndActiveIsTrue(String code);

    Optional<DocumentType> getByCode(String code);
}