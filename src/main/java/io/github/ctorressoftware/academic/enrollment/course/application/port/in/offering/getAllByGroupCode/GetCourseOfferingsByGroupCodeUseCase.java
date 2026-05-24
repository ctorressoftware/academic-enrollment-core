package io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.getAllByGroupCode;

public interface GetCourseOfferingsByGroupCodeUseCase {
    GetCourseOfferingsByGroupCodeResult getAll(
            GetCourseOfferingsByGroupCodeCommand command);
}
