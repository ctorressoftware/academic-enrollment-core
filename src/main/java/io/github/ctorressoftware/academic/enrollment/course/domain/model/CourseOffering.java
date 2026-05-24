package io.github.ctorressoftware.academic.enrollment.course.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class CourseOffering {
    private final UUID id;
    private final String groupCode; // Apply nanoid
    private final UUID academicPeriodId;
    private final UUID subjectId;
    private final UUID teacherId;
    private final short courseStateId;
    private final short quotas;
    private final Instant createdAt;
    private final Instant updatedAt;

    public CourseOffering(
            UUID id,
            String groupCode,
            UUID academicPeriodId,
            UUID subjectId,
            UUID teacherId,
            short courseStateId,
            short quotas,
            Instant createdAt,
            Instant updatedAt) {
        this.id = id;
        this.groupCode = Objects.requireNonNull(groupCode, "groupCode is null");
        this.academicPeriodId = Objects.requireNonNull(academicPeriodId, "academicPeriodId is null");
        this.subjectId = Objects.requireNonNull(subjectId, "subjectId is null");
        this.teacherId = Objects.requireNonNull(teacherId, "teacherId is null");
        this.courseStateId = courseStateId;
        this.quotas = quotas;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is null");
    }

    public static CourseOffering create(
            String groupCode,
            UUID academicPeriodId,
            UUID subjectId,
            UUID teacherId,
            short courseStateId,
            short quotas
    ) {
        Instant now = Instant.now();
        return new CourseOffering(
                UUID.randomUUID(),
                groupCode,
                academicPeriodId,
                subjectId,
                teacherId,
                courseStateId,
                quotas,
                now,
                now
        );
    }

    public static CourseOffering restore(
            UUID id,
            String groupCode,
            UUID academicPeriodId,
            UUID subjectId,
            UUID teacherId,
            short courseStateId,
            short quotas,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new CourseOffering(
                id,
                groupCode,
                academicPeriodId,
                subjectId,
                teacherId,
                courseStateId,
                quotas,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public UUID getAcademicPeriodId() {
        return academicPeriodId;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public short getCourseStateId() {
        return courseStateId;
    }

    public short getQuotas() {
        return quotas;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
