package io.github.ctorressoftware.academic.enrollment.subject.application.port.in.subject.getAll;

// TODO: implement pagination
public interface GetAllSubjectsUseCase {
    GetAllSubjectsResult getAll(GetAllSubjectsCommand command);
}
