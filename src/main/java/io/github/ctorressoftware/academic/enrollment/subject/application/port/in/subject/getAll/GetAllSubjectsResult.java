package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;

import java.util.List;

public record GetAllSubjectsResult(List<Subject> subjects) {}
