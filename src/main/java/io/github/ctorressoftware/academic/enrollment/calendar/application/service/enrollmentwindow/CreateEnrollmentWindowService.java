package io.github.ctorressoftware.academic.enrollment.calendar.application.service.enrollmentwindow;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.AcademicPeriodRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.out.EnrollmentWindowRepository;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.AcademicPeriod;
import io.github.ctorressoftware.academic.enrollment.calendar.domain.model.EnrollmentWindow;
import org.springframework.stereotype.Service;

@Service
public class CreateEnrollmentWindowService implements CreateEnrollmentWindowUseCase {

    private final AcademicPeriodRepository academicPeriodRepository;
    private final EnrollmentWindowRepository enrollmentWindowRepository;

    public CreateEnrollmentWindowService(
            AcademicPeriodRepository academicPeriodRepository,
            EnrollmentWindowRepository enrollmentWindowRepository
    ) {
        this.academicPeriodRepository = academicPeriodRepository;
        this.enrollmentWindowRepository = enrollmentWindowRepository;
    }

    @Override
    public CreateEnrollmentWindowResult create(CreateEnrollmentWindowCommand command) {
        AcademicPeriod academicPeriod = academicPeriodRepository
                .findById(command.academicPeriodId())
                .orElseThrow(() -> new IllegalArgumentException("Academic period not found"));

        enrollmentWindowRepository
                .findActiveByAcademicPeriodId(academicPeriod.getId())
                .ifPresent(enrollmentWindow -> {
                    throw new IllegalArgumentException("An active enrollment window already exists for this academic period");
                });

        EnrollmentWindow enrollmentWindow = EnrollmentWindow.create(
                academicPeriod.getId(),
                command.type(),
                command.opensAt(),
                command.closesAt()
        );

        EnrollmentWindow saved = enrollmentWindowRepository.save(enrollmentWindow);

        return new CreateEnrollmentWindowResult(saved);
    }
}