package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode;

public interface GetSubjectByCodeUseCase {
    GetSubjectByCodeResult getByCode(GetSubjectByCodeCommand command);
}
