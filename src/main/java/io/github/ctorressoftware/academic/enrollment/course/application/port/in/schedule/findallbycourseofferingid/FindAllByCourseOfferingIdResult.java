package io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid;

import io.github.ctorressoftware.academic.enrollment.course.domain.model.CourseSchedule;

import java.util.List;

public record FindAllByCourseOfferingIdResult(List<CourseSchedule> courseScheduleList) {}
