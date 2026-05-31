package io.github.ctorressoftware.academic.enrollment.calendar.application.service.academicperiod;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.AcademicPeriodRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;
import org.springframework.stereotype.Service;

@Service
public class FindByQuarterAndYearAndIsActiveService implements FindByQuarterAndYearAndIsActiveUseCase {

    private final AcademicPeriodRepository academicPeriodRepository;

    public FindByQuarterAndYearAndIsActiveService(AcademicPeriodRepository academicPeriodRepository) {
        this.academicPeriodRepository = academicPeriodRepository;
    }

    @Override
    public FindByQuarterAndYearAndIsActiveResult find(FindByQuarterAndYearAndIsActiveCommand command) {
        AcademicPeriod academicPeriod = academicPeriodRepository
                .findActiveByQuarterAndYear(command.quarter(), command.year())
                .orElseThrow(() -> new IllegalArgumentException("Academic period not found"));

        return new FindByQuarterAndYearAndIsActiveResult(academicPeriod);
    }
}