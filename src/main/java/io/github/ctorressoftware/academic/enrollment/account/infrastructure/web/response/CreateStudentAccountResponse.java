package io.github.ctorressoftware.academic.enrollment.account.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Person;
import io.github.ctorressoftware.academic.enrollment.student.domain.model.Student;

public record CreateStudentAccountResponse(
        Person person,
        Student student,
        String username,
        String accessToken
) {}
