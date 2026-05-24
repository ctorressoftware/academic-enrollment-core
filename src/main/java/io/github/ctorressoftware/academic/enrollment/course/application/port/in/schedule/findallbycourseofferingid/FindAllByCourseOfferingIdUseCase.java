package io.github.ctorressoftware.academic.enrollment.course.application.port.in.schedule.findallbycourseofferingid;

import java.util.UUID;

public interface FindAllByCourseOfferingIdUseCase {
    FindAllByCourseOfferingIdResult findAll(UUID courseOfferingId);
}