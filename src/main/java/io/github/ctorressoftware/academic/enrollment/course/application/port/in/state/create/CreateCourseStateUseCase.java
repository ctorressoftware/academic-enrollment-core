package io.github.ctorressoftware.academic.enrollment.course.application.port.in.state.create;

public interface CreateCourseStateUseCase {
    CreateCourseStateResult create(CreateCourseStateCommand command);
}
