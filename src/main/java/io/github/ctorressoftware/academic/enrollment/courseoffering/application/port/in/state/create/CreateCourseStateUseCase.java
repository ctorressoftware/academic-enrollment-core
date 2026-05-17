package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.state.create;

public interface CreateCourseStateUseCase {
    CreateCourseStateResult create(CreateCourseStateCommand command);
}
