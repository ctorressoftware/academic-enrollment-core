package io.github.ctorressoftware.academic.enrollment.course.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateCommand;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.getall.GetAllCourseStatesResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.getall.GetAllCourseStatesUseCase;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.request.CreateCourseStateRequest;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response.CreateCourseStateResponse;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response.GetAllCourseStatesResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/course-state")
public class CourseStateController {
    private final CreateCourseStateUseCase createUseCase;
    private final GetAllCourseStatesUseCase getAllUseCase;

    public CourseStateController(
            CreateCourseStateUseCase createUseCase,
            GetAllCourseStatesUseCase getAllUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<CreateCourseStateResponse>> create(
            @RequestBody @Valid CreateCourseStateRequest request) {

        CreateCourseStateCommand command = new CreateCourseStateCommand(
                request.id(),
                request.code(),
                request.description()
        );

        CreateCourseStateResult result = createUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateCourseStateResponse(result.state())
        ));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<ApiResponse<GetAllCourseStatesResponse>> getAll() {

        GetAllCourseStatesResult result = getAllUseCase.getAll();

        return ResponseEntity.ok(ApiResponse.success(
                new GetAllCourseStatesResponse(result.states())
        ));
    }
}
