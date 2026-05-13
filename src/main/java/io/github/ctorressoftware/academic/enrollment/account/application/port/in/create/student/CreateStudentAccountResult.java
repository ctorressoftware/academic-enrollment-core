package io.github.ctorressoftware.academic.enrollment.account.application.port.in.create.student;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.person.Person;
import io.github.ctorressoftware.academic.enrollment.student.domain.model.Student;

public record CreateStudentAccountResult(
        Person person,
        Student student,
        String username,
        String accessToken
) {}
