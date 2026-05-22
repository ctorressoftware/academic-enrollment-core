package io.github.ctorressoftware.academic.enrollment.subject.application.port.out;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;

import java.util.List;
import java.util.UUID;

public interface PrerequisiteRepository {
    Prerequisite save(Prerequisite prerequisite);
    List<Prerequisite> findAllBySubjectId(UUID subjectId);
}
