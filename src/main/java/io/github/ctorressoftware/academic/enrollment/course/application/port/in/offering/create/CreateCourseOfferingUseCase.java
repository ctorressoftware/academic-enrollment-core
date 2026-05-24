package io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.create;

public interface CreateCourseOfferingUseCase {
    CreateCourseOfferingResult create(CreateCourseOfferingCommand command);
}
