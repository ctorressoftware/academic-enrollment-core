package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.AcademicPeriodRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.entity.AcademicPeriodEntity;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.persistence.repository.SpringDataAcademicPeriodRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class JpaAcademicPeriodRepositoryAdapter implements AcademicPeriodRepository {

    private final SpringDataAcademicPeriodRepository repository;

    public JpaAcademicPeriodRepositoryAdapter(SpringDataAcademicPeriodRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicPeriod save(AcademicPeriod academicPeriod) {
        AcademicPeriodEntity saved = repository.save(toEntity(academicPeriod));
        return toDomain(saved);
    }

    @Override
    public Optional<AcademicPeriod> findById(UUID academicPeriodId) {
        return repository.findById(academicPeriodId)
                .map(this::toDomain);
    }

    @Override
    public Optional<AcademicPeriod> findActiveByQuarterAndYear(String quarter, short year) {

        return repository
                .findByQuarterAndYearAndActiveIsTrue(quarter, year)
                .map(this::toDomain);
    }

    private AcademicPeriod toDomain(AcademicPeriodEntity entity) {
        return AcademicPeriod.restore(
                entity.getId(),
                entity.getQuarter(),
                entity.getYear(),
                entity.getActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private AcademicPeriodEntity toEntity(AcademicPeriod academicPeriod) {
        AcademicPeriodEntity entity = new AcademicPeriodEntity();
        entity.setId(academicPeriod.getId());
        entity.setQuarter(academicPeriod.getQuarter());
        entity.setYear(academicPeriod.getYear());
        entity.setActive(academicPeriod.isActive());
        entity.setCreatedAt(academicPeriod.getCreatedAt());
        entity.setUpdatedAt(academicPeriod.getUpdatedAt());
        return entity;
    }
}