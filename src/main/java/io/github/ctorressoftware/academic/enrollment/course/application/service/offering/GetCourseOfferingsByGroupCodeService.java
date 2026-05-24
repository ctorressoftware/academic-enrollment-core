package io.github.ctorressoftware.academic.enrollment.courseoffering.application.service.offering;

import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.getAllByGroupCode.GetCourseOfferingsByGroupCodeCommand;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.getAllByGroupCode.GetCourseOfferingsByGroupCodeResult;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.offering.getAllByGroupCode.GetCourseOfferingsByGroupCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.out.CourseOfferingRepository;
import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseOffering;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCourseOfferingsByGroupCodeService
        implements GetCourseOfferingsByGroupCodeUseCase {

    private final CourseOfferingRepository repository;

    public GetCourseOfferingsByGroupCodeService(
            CourseOfferingRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetCourseOfferingsByGroupCodeResult getAll(GetCourseOfferingsByGroupCodeCommand command) {

        List<CourseOffering> courseOfferings =
                repository.getAllByGroupCode(command.groupCode());

        return new GetCourseOfferingsByGroupCodeResult(courseOfferings);
    }
}
