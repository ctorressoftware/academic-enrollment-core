package io.github.ctorressoftware.academic.enrollment.course.infrastructure.web.request;

import jakarta.validation.constraints.*;

import java.time.LocalTime;
import java.util.UUID;

public record CreateCourseScheduleRequest(
        @NotNull(message = "courseOfferingId cannot be null")
        UUID courseOfferingId,

        @NotNull(message = "weekDay cannot be null")
        @Min(value = 1, message = "weekDay cannot be lower than 1")
        @Max(value = 7, message = "weekDay cannot be higher than 7")
        Short weekDay,

        @NotNull(message = "startTime cannot be null")
        LocalTime startTime,

        @NotNull(message = "endTime cannot be null")
        LocalTime endTime,

        @NotBlank(message = "location cannot be blank")
        @Size(max = 150, message = "location cannot exceed 150 characters")
        String location
) {
    public boolean hasValidTimeRange() {
        return startTime != null
                && endTime != null
                && endTime.isAfter(startTime);
    }
}
