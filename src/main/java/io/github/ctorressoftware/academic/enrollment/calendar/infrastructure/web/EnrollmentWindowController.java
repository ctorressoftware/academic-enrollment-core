package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.create.CreateEnrollmentWindowUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.enrollmentwindow.findbyacademicperiodid.FindByAcademicPeriodIdAndIsActiveUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.request.CreateEnrollmentWindowRequest;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.response.CreateEnrollmentWindowResponse;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.response.FindByAcademicPeriodIdAndIsActiveResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/enrollment-window")
public class EnrollmentWindowController {

    private final CreateEnrollmentWindowUseCase createEnrollmentWindowUseCase;
    private final FindByAcademicPeriodIdAndIsActiveUseCase findByAcademicPeriodIdAndIsActiveUseCase;

    public EnrollmentWindowController(
            CreateEnrollmentWindowUseCase createEnrollmentWindowUseCase,
            FindByAcademicPeriodIdAndIsActiveUseCase findByAcademicPeriodIdAndIsActiveUseCase
    ) {
        this.createEnrollmentWindowUseCase = createEnrollmentWindowUseCase;
        this.findByAcademicPeriodIdAndIsActiveUseCase = findByAcademicPeriodIdAndIsActiveUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateEnrollmentWindowResponse>> create(
            @RequestBody @Valid CreateEnrollmentWindowRequest request
    ) {
        CreateEnrollmentWindowCommand command = new CreateEnrollmentWindowCommand(
                request.academicPeriodId(),
                request.type(),
                request.opensAt(),
                request.closesAt()
        );

        CreateEnrollmentWindowResult result = createEnrollmentWindowUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateEnrollmentWindowResponse(
                result.enrollmentWindow()
        )));
    }

    @GetMapping("/findByAcademicPeriodId")
    public ResponseEntity<ApiResponse<FindByAcademicPeriodIdAndIsActiveResponse>> findByAcademicPeriodIdAndIsActive(
            @RequestParam UUID academicPeriodId
    ) {
        FindByAcademicPeriodIdAndIsActiveCommand command =
                new FindByAcademicPeriodIdAndIsActiveCommand(academicPeriodId);

        FindByAcademicPeriodIdAndIsActiveResult result = findByAcademicPeriodIdAndIsActiveUseCase.find(command);

        return ResponseEntity.ok(ApiResponse.success(new FindByAcademicPeriodIdAndIsActiveResponse(
                result.enrollmentWindow()
        )));
    }
}