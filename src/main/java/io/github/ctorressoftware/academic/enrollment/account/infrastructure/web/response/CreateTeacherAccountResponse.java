package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Person;
import io.github.ctorressoftware.academic.enrollment.teacher.domain.model.Teacher;

public record CreateTeacherAccountResponse(
        Person person,
        Teacher teacher,
        String username,
        String accessToken
) {}
