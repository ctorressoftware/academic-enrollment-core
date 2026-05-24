package io.github.ctorressoftware.academic.enrollment.course.application.service.schedule;

import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid.FindAllByCourseOfferingIdResult;
import io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid.FindAllByCourseOfferingIdUseCase;
import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseScheduleRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FindAllByCourseOfferingIdService implements FindAllByCourseOfferingIdUseCase {

    private final CourseScheduleRepository repository;

    public FindAllByCourseOfferingIdService(CourseScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FindAllByCourseOfferingIdResult findAll(UUID courseOfferingId) {

        List<CourseSchedule> courseScheduleList = repository
                .findAllByCourseOfferingId(courseOfferingId);

        return new FindAllByCourseOfferingIdResult(courseScheduleList);
    }
}
