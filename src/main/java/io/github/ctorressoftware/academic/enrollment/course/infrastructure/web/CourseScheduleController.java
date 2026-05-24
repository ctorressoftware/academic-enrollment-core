package io.github.ctorressoftware.academic.enrollment.course.infrastructure.web;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleCommand;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid.FindAllByCourseOfferingIdResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid.FindAllByCourseOfferingIdUseCase;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.request.CreateCourseScheduleRequest;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response.CreateCourseScheduleResponse;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.response.FindAllByCourseOfferingIdResponse;
import io.github.ctorressoftware.academic.enrollment.shared.infrastructure.web.response.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/courseschedule")
public class CourseScheduleController {
    private final CreateCourseScheduleUseCase createUseCase;
    private final FindAllByCourseOfferingIdUseCase findAllUseCase;

    public CourseScheduleController(
            CreateCourseScheduleUseCase createUseCase,
            FindAllByCourseOfferingIdUseCase findAllUseCase) {
        this.createUseCase = createUseCase;
        this.findAllUseCase = findAllUseCase;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ApiResponse<CreateCourseScheduleResponse>> create(
            @RequestBody @Valid CreateCourseScheduleRequest request) {

        CreateCourseScheduleCommand command = new CreateCourseScheduleCommand(
                request.courseOfferingId(),
                request.weekDay(),
                request.startTime(),
                request.endTime(),
                request.location()
        );

        CreateCourseScheduleResult result = createUseCase.create(command);

        return ResponseEntity.ok(ApiResponse.success(
                new CreateCourseScheduleResponse(result.schedule())
        ));
    }

    @GetMapping(value = "/findAllByCourseOfferingId")
    public ResponseEntity<ApiResponse<FindAllByCourseOfferingIdResponse>> findAll(
            @Valid @NotNull(message = "courseOfferingId cannot be null") UUID courseOfferingId) {

        FindAllByCourseOfferingIdResult result = findAllUseCase.findAll(courseOfferingId);

        return ResponseEntity.ok(ApiResponse.success(
                new FindAllByCourseOfferingIdResponse(result.courseScheduleList())
        ));
    }
}
