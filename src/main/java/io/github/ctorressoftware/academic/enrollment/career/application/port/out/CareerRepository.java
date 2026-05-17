package io.github.ctorressoftware.academic.enrollment.career.application.port.out;

import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;

import java.util.List;
import java.util.Optional;

public interface CareerRepository {
    Career save(Career career);
    Optional<Career> getByCode(String code);
    List<Career> getAll();
}
