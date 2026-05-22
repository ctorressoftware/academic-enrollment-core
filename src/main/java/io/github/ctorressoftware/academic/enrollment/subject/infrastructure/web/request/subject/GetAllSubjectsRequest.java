package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.request.subject;

import jakarta.validation.constraints.Size;

public record GetAllSubjectsRequest(
        @Size(min = 0, message = "page has to be higher than zero")
        int page,

        @Size(min = 0, message = "pageSize has to be higher than zero")
        int pageSize
) {}
