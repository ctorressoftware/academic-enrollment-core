package io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.out;

import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseOffering;

import java.util.List;
import java.util.UUID;

public interface CourseOfferingRepository {
    CourseOffering save(CourseOffering courseOffering);
    List<CourseOffering> getAllByGroupCode(String groupCode);
}
