package io.github.ctorressoftware.academic.enrollment.courseoffering.application.service;

import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.course.create.CreateCourseOfferingCommand;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.course.create.CreateCourseOfferingResult;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.course.create.CreateCourseOfferingUseCase;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.out.CourseOfferingRepository;
import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseOffering;
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
