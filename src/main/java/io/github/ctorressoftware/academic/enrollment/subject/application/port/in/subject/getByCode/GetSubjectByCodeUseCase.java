package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getByCode;

public interface GetSubjectByCodeUseCase {
    GetSubjectByCodeResult getByCode(GetSubjectByCodeCommand command);
}
