package io.github.ctorressoftware.academic.enrollment.subject.domain.exception;

public class PrerequisiteCircularDependencyException extends RuntimeException {
    public PrerequisiteCircularDependencyException() {
        super("subjectId and prerequisiteSubjectId cannot be the same id");
    }
}
