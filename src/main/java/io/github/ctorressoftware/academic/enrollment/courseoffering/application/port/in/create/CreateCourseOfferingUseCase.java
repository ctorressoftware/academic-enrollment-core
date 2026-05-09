package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.create;

public interface CreateCourseOfferingUseCase {
    CreateCourseOfferingResult create(CreateCourseOfferingCommand command);
}
