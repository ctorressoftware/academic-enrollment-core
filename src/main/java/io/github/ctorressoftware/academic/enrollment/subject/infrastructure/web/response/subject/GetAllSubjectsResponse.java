package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;

import java.util.List;

public record GetAllSubjectsResponse(List<Subject> subjects) {}
