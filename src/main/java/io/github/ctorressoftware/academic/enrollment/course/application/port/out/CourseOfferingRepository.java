package io.github.ctorressoftware.academic.enrollment.course.application.port.out;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseOffering;

import java.util.List;

public interface CourseOfferingRepository {
    CourseOffering save(CourseOffering courseOffering);
    List<CourseOffering> getAllByGroupCode(String groupCode);
}
