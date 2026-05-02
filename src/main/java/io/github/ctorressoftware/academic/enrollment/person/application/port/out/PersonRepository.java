package io.github.ctorressoftware.academic.enrollment.person.application.port.out;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;

public interface PersonRepository {
    Person save(Person person);
}
