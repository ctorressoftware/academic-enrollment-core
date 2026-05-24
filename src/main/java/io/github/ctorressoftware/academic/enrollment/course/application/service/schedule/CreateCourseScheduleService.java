package io.github.ctorressoftware.academic.enrollment.course.application.service.schedule;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleCommand;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create.CreateCourseScheduleUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseScheduleRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseScheduleService implements CreateCourseScheduleUseCase {

    private final CourseScheduleRepository repository;

    public CreateCourseScheduleService(CourseScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCourseScheduleResult create(CreateCourseScheduleCommand command) {

        CourseSchedule courseSchedule = CourseSchedule.create(
                command.courseOfferingId(),
                command.weekDay(),
                command.startTime(),
                command.endTime(),
                command.location()
        );

        CourseSchedule saved = repository.save(courseSchedule);

        return new CreateCourseScheduleResult(saved);
    }
}
