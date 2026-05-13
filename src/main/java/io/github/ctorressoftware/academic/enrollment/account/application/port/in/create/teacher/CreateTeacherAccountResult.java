package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.teacher;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Person;
import io.github.ctorressoftware.academic.enrollment.teacher.domain.model.Teacher;

public record CreateTeacherAccountResult(
        Person person,
        Teacher teacher,
        String username,
        String accessToken
) {}
