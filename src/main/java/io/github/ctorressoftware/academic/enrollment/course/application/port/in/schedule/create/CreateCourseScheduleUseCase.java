package io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create;

public interface CreateCourseScheduleUseCase {
    CreateCourseScheduleResult create(CreateCourseScheduleCommand command);
}
