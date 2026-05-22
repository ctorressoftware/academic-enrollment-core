package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid;

import java.util.UUID;

public interface GetAllBySubjectIdUseCase {
    GetAllBySubjectIdResult getAllBySubjectId(UUID subjectId);
}
