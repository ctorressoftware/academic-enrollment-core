package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;

import java.util.List;

public record GetAllBySubjectIdResult(List<Prerequisite> prerequisites) {}
