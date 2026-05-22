package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.entity.PrerequisiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataPrerequisiteRepository extends JpaRepository<PrerequisiteEntity, UUID> {
    List<PrerequisiteEntity> getAllBySubjectId(UUID subjectId);
}
