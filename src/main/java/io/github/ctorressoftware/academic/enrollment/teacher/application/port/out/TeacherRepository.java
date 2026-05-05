package io.github.ctorressoftware.academic.enrollment.teacher.application.port.out;

import io.github.ctorressoftware.academic.enrollment.teacher.domain.model.Teacher;

public interface TeacherRepository {
    Teacher save(Teacher teacher);
}