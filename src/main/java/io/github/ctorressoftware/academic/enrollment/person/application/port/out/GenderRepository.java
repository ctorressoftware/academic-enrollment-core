package io.github.ctorressoftware.academic.enrollment.person.application.port.out;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.gender.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderRepository {
    Gender save(Gender gender);
    Optional<Gender> getByCode(String code);
    List<Gender> getAllByCodeAndIsActive(String code);
    Gender update(Gender gender);
    void remove(short id);
}
