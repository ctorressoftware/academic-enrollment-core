package io.github.ctorressoftware.academic.enrollment.course.application.service.offering;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.create.CreateCourseOfferingCommand;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.create.CreateCourseOfferingResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.offering.create.CreateCourseOfferingUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseOfferingRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseOffering;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseOfferingService implements CreateCourseOfferingUseCase {

    private final CourseOfferingRepository repository;

    public CreateCourseOfferingService(CourseOfferingRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCourseOfferingResult create(CreateCourseOfferingCommand command) {

        CourseOffering courseOffering = CourseOffering.create(
                command.groupCode(),
                command.academicPeriodId(),
                command.subjectId(),
                command.teacherId(),
                command.courseStateId(),
                command.quotas()
        );

        CourseOffering saved = repository.save(courseOffering);

        return new CreateCourseOfferingResult(saved);
    }
}
