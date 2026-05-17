package io.github.ctorressoftware.academic.enrollment.career.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerCommand;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerUseCase;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getall.GetAllCareersResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getall.GetAllCareersUseCase;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getbycode.GetCareerByCodeResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getbycode.GetCareerByCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;
import io.github.ctorressoftware.academic.enrollment.career.infrastructure.web.request.CreateCareerRequest;
import io.github.ctorressoftware.academic.enrollment.career.infrastructure.web.response.CreateCareerResponse;
import io.github.ctorressoftware.academic.enrollment.career.infrastructure.web.response.GetAllCareersResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/career")
public class CareerController {
    private final CreateCareerUseCase createUseCase;
    private final GetAllCareersUseCase getAllUseCase;
    private final GetCareerByCodeUseCase getByCodeUseCase;

    public CareerController(
            CreateCareerUseCase createUseCase,
            GetAllCareersUseCase getAllUseCase,
            GetCareerByCodeUseCase getByCodeUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByCodeUseCase = getByCodeUseCase;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<CreateCareerResponse>> create(
            @RequestBody @Valid CreateCareerRequest request) {

        CreateCareerCommand command = new CreateCareerCommand(
                request.code(),
                request.description()
        );

        CreateCareerResult result = createUseCase.create(command);
        return ResponseEntity.ok(ApiResponse.success(
                new CreateCareerResponse(result.career())
        ));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ApiResponse<GetAllCareersResponse>> getAll() {
        GetAllCareersResult result = getAllUseCase.getAll();
        return ResponseEntity.ok(ApiResponse.success(
                new GetAllCareersResponse(result.careers())
        ));
    }

    @GetMapping(value = "/getByCode")
    public ResponseEntity<ApiResponse<CreateCareerResponse>> getByCode(
            @Valid @NotBlank(message = "code cannot be blank") String code) {
        GetCareerByCodeResult result = getByCodeUseCase.getByCode(code);
        return ResponseEntity.ok(ApiResponse.success(
                new CreateCareerResponse(result.career())
        ));
    }
}
