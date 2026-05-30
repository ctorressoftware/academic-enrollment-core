package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.entity.AcademicPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataAcademicPeriodRepository
        extends JpaRepository<AcademicPeriodEntity, UUID> {

    Optional<AcademicPeriodEntity> findByQuarterAndYearAndActiveIsTrue(String quarter, Short year);
}
