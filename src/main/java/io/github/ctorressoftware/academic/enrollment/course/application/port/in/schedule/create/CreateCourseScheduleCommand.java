package io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.create;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.WeekDay;

import java.time.LocalTime;
import java.util.UUID;

public record CreateCourseScheduleCommand(
        UUID courseOfferingId,
        short weekDay,
        LocalTime startTime,
        LocalTime endTime,
        String location
) {}
