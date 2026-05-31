package io.github.ctorressoftware.academic.enrollment.calendar.application.service.academicperiod;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.AcademicPeriodRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;
import org.springframework.stereotype.Service;

@Service
public class CreateAcademicPeriodService implements CreateAcademicPeriodUseCase {

    private final AcademicPeriodRepository academicPeriodRepository;

    public CreateAcademicPeriodService(AcademicPeriodRepository academicPeriodRepository) {
        this.academicPeriodRepository = academicPeriodRepository;
    }

    @Override
    public CreateAcademicPeriodResult create(CreateAcademicPeriodCommand command) {
        academicPeriodRepository
                .findActiveByQuarterAndYear(command.quarter(), command.year())
                .ifPresent(academicPeriod -> {
                    throw new IllegalArgumentException("Academic period already exists");
                });

        AcademicPeriod academicPeriod = AcademicPeriod.create(command.quarter(), command.year());

        AcademicPeriod saved = academicPeriodRepository.save(academicPeriod);

        return new CreateAcademicPeriodResult(saved);
    }
}