package io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class CourseSchedule {
    private final UUID id;
    private final UUID courseOfferingId;
    private final String weekDay;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String location;
    private final Instant createdAt;
    private final Instant updatedAt;

    private CourseSchedule(
            UUID id,
            UUID courseOfferingId,
            String weekDay,
            LocalTime startTime,
            LocalTime endTime,
            String location,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.courseOfferingId = Objects.requireNonNull(courseOfferingId, "courseOfferingId cannot be null");
        this.weekDay = Objects.requireNonNull(weekDay, "weekDay cannot be null");
        this.startTime = Objects.requireNonNull(startTime, "startTime cannot be null");
        this.endTime = Objects.requireNonNull(endTime, "endTime cannot be null");
        this.location = Objects.requireNonNull(location, "location cannot be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt cannot be null");
    }

    public static CourseSchedule create(
            UUID courseOfferingId,
            String weekDay,
            LocalTime startTime,
            LocalTime endTime,
            String location
    ) {
        Instant now = Instant.now();

        return new CourseSchedule(
                UUID.randomUUID(),
                courseOfferingId,
                weekDay,
                startTime,
                endTime,
                location,
                now,
                now
        );
    }

    public static CourseSchedule restore(
            UUID id,
            UUID courseOfferingId,
            String weekDay,
            LocalTime startTime,
            LocalTime endTime,
            String location,
            Instant createdAt,
            Instant updatedAt
    ) {
        return new CourseSchedule(
                id,
                courseOfferingId,
                weekDay,
                startTime,
                endTime,
                location,
                createdAt,
                updatedAt
        );
    }

    public UUID getId() {
        return id;
    }

    public UUID getCourseOfferingId() {
        return courseOfferingId;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
