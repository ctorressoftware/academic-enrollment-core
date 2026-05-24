package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.create;

public interface CreateCourseOfferingUseCase {
    CreateCourseOfferingResult create(CreateCourseOfferingCommand command);
}
