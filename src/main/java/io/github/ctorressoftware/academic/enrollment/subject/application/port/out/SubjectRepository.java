package io.github.ctorressoftware.academic.enrollment.subject.application.port.out;

import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    Subject save(Subject subject);
    Optional<Subject> findByCode(String code);
    List<Subject> findAll(int page, int pageSize);
}
