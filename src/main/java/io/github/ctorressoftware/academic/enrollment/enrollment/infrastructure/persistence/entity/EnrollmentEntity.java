package io.github.ctorressoftware.academic.enrollment.enrollment.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "enrollment", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "student_id", "course_offering_id" })
})
public class EnrollmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "student_id", nullable = false)
    private UUID studentId;

    @Column(name = "course_offering_id", nullable = false)
    private UUID courseOfferingId;

    @Column(name = "enrollment_state_id", nullable = false)
    private short enrollmentStateId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(UUID courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public short getEnrollmentStateId() {
        return enrollmentStateId;
    }

    public void setEnrollmentStateId(short enrollmentStateId) {
        this.enrollmentStateId = enrollmentStateId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
