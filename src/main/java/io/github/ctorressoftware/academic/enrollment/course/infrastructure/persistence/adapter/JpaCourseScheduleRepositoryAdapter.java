package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseScheduleRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseScheduleEntity;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository.SpringDataCourseScheduleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JpaCourseScheduleRepositoryAdapter implements CourseScheduleRepository {

    private final SpringDataCourseScheduleRepository repository;

    public JpaCourseScheduleRepositoryAdapter(SpringDataCourseScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseSchedule save(CourseSchedule courseSchedule) {
        CourseScheduleEntity saved = repository.save(toEntity(courseSchedule));
        return toDomain(saved);
    }

    @Override
    public List<CourseSchedule> findAllByCourseOfferingId(UUID courseOfferingId) {
        return repository.findAllByCourseOfferingId(courseOfferingId).stream()
                .map(this::toDomain)
                .toList();
    }

    private CourseSchedule toDomain(CourseScheduleEntity entity) {
        return CourseSchedule.restore(
                entity.getId(),
                entity.getCourseOfferingId(),
                entity.getWeekDay(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getLocation(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private CourseScheduleEntity toEntity(CourseSchedule courseSchedule) {
        CourseScheduleEntity entity = new CourseScheduleEntity();
        entity.setId(courseSchedule.getId());
        entity.setCourseOfferingId(courseSchedule.getCourseOfferingId());
        entity.setWeekDay(courseSchedule.getWeekDay());
        entity.setStartTime(courseSchedule.getStartTime());
        entity.setEndTime(courseSchedule.getEndTime());
        entity.setLocation(courseSchedule.getLocation());
        entity.setCreatedAt(courseSchedule.getCreatedAt());
        entity.setUpdatedAt(courseSchedule.getUpdatedAt());
        return entity;
    }
}