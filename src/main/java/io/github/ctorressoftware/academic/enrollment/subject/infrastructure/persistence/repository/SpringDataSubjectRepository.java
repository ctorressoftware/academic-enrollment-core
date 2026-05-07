package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.subject.infrastructure.persistence.entity.SubjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataSubjectRepository extends JpaRepository<SubjectEntity, UUID> {
    Optional<SubjectEntity> findSubjectEntityByCode(String code);

    @Override
    Page<SubjectEntity> findAll(Pageable pageable);
}
