package io.github.ctorressoftware.academic.enrollment.course.application.service.state;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateCommand;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create.CreateCourseStateUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseStateRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseState;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseStateService implements CreateCourseStateUseCase {

    private final CourseStateRepository repository;

    public CreateCourseStateService(CourseStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCourseStateResult create(CreateCourseStateCommand command) {

        CourseState state = CourseState.create(
                command.id(),
                command.code(),
                command.description()
        );

        CourseState saved = repository.save(state);

        return new CreateCourseStateResult(saved);
    }
}
