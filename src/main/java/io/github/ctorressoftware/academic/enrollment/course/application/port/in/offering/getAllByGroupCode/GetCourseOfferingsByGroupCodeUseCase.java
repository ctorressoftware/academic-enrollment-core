package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.getAllByGroupCode;

public interface GetCourseOfferingsByGroupCodeUseCase {
    GetCourseOfferingsByGroupCodeResult getAll(
            GetCourseOfferingsByGroupCodeCommand command);
}
