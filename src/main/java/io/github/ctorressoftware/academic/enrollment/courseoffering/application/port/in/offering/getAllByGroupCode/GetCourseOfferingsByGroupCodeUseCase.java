package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.course.getAllByGroupCode;

public interface GetCourseOfferingsByGroupCodeUseCase {
    GetCourseOfferingsByGroupCodeResult getAll(
            GetCourseOfferingsByGroupCodeCommand command);
}
