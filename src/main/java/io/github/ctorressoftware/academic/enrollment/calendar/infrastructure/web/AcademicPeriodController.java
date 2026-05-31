package io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.create.CreateAcademicPeriodUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveCommand;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveResult;
import io.github.ctorressoftware.academic.enrollment.calendar.application.port.in.academicperiod.findbyquarterandyear.FindByQuarterAndYearAndIsActiveUseCase;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.request.CreateAcademicPeriodRequest;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.response.CreateAcademicPeriodResponse;
import io.github.ctorressoftware.academic.enrollment.calendar.infrastructure.web.response.FindByQuarterAndYearAndIsActiveResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/academic-period")
public class AcademicPeriodController {

    private final CreateAcademicPeriodUseCase createAcademicPeriodUseCase;
    private final FindByQuarterAndYearAndIsActiveUseCase findByQuarterAndYearAndIsActiveUseCase;

    public AcademicPeriodController(
            CreateAcademicPeriodUseCase createAcademicPeriodUseCase,
            FindByQuarterAndYearAndIsActiveUseCase findByQuarterAndYearAndIsActiveUseCase
    ) {
        this.createAcademicPeriodUseCase = createAcademicPeriodUseCase;
        this.findByQuarterAndYearAndIsActiveUseCase = findByQuarterAndYearAndIsActiveUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CreateAcademicPeriodResponse>> create(
            @RequestBody @Valid CreateAcademicPeriodRequest request
    ) {
        CreateAcademicPeriodCommand command = new CreateAcademicPeriodCommand(
                request.quarter(),
                request.year()
        );

        CreateAcademicPeriodResult result = createAcademicPeriodUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(new CreateAcademicPeriodResponse(
                result.academicPeriod()
        )));
    }

    @GetMapping("/findByQuarterAndYear")
    public ResponseEntity<ApiResponse<FindByQuarterAndYearAndIsActiveResponse>> findByQuarterAndYearAndIsActive(
            @RequestParam String quarter,
            @RequestParam short year
    ) {
        FindByQuarterAndYearAndIsActiveCommand command = new FindByQuarterAndYearAndIsActiveCommand(quarter, year);

        FindByQuarterAndYearAndIsActiveResult result = findByQuarterAndYearAndIsActiveUseCase.find(command);

        return ResponseEntity.ok(ApiResponse.success(new FindByQuarterAndYearAndIsActiveResponse(
                result.academicPeriod()
        )));
    }
}