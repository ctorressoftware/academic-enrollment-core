package io.github.ctorressoftware.academic.enrollment.subject.infrastructure.web.response.prerequisite;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;

import java.util.List;

public record GetAllBySubjectIdResponse(List<Prerequisite> prerequisites) {}
