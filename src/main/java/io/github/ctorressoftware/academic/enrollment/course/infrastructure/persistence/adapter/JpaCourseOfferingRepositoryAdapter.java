package io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.course.application.port.out.CourseOfferingRepository;
import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseOffering;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.entity.CourseOfferingEntity;
import io.github.ctorressoftware.academic.enrollment.course.infrastructure.persistence.repository.SpringDataCourseOfferingRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaCourseOfferingRepositoryAdapter
        implements CourseOfferingRepository {

    private final SpringDataCourseOfferingRepository repository;

    public JpaCourseOfferingRepositoryAdapter(
            SpringDataCourseOfferingRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseOffering save(CourseOffering courseOffering) {
        CourseOfferingEntity entity = repository.save(toEntity(courseOffering));
        return toDomain(entity);
    }

    @Override
    public List<CourseOffering> getAllByGroupCode(String groupCode) {

        List<CourseOfferingEntity> courseOfferingEntities =
                repository.getAllByGroupCode(groupCode);

        return courseOfferingEntities.stream()
                .map(this::toDomain)
                .toList();
    }

    private CourseOffering toDomain(CourseOfferingEntity entity) {

        return CourseOffering.restore(
                entity.getId(),
                entity.getGroupCode(),
                entity.getAcademicPeriodId(),
                entity.getSubjectId(),
                entity.getTeacherId(),
                entity.getCourseStateId(),
                entity.getQuotas(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private CourseOfferingEntity toEntity(CourseOffering courseOffering) {
        CourseOfferingEntity entity = new CourseOfferingEntity();
        entity.setId(courseOffering.getId());
        entity.setGroupCode(courseOffering.getGroupCode());
        entity.setAcademicPeriodId(courseOffering.getAcademicPeriodId());
        entity.setSubjectId(courseOffering.getSubjectId());
        entity.setTeacherId(courseOffering.getTeacherId());
        entity.setCourseStateId(courseOffering.getCourseStateId());
        entity.setQuotas(courseOffering.getQuotas());
        entity.setCreatedAt(courseOffering.getCreatedAt());
        entity.setUpdatedAt(courseOffering.getUpdatedAt());
        return entity;
    }
}
