package io.github.ctorressoftware.academic.enrollment.calendar.application.service.enrollmentwindow;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.EnrollmentWindowRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.EnrollmentWindow;
import org.springframework.stereotype.Service;

@Service
public class FindByAcademicPeriodIdAndIsActiveService implements FindByAcademicPeriodIdAndIsActiveUseCase {

    private final EnrollmentWindowRepository enrollmentWindowRepository;

    public FindByAcademicPeriodIdAndIsActiveService(EnrollmentWindowRepository enrollmentWindowRepository) {
        this.enrollmentWindowRepository = enrollmentWindowRepository;
    }

    @Override
    public FindByAcademicPeriodIdAndIsActiveResult find(FindByAcademicPeriodIdAndIsActiveCommand command) {
        EnrollmentWindow enrollmentWindow = enrollmentWindowRepository
                .findActiveByAcademicPeriodId(command.academicPeriodId())
                .orElseThrow(() -> new IllegalArgumentException("Enrollment window not found"));

        return new FindByAcademicPeriodIdAndIsActiveResult(enrollmentWindow);
    }
}