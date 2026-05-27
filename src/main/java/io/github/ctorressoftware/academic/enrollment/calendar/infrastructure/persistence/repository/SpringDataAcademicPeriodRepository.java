package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataAcademicPeriodRepository
        extends JpaRepository<AcademicPeriod, UUID> {

}
