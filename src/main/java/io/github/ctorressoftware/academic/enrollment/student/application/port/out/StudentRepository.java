package io.github.ctorressoftware.academic.enrollment.student.application.port.out;

import io.github.ctorressoftware.academic.enrollment.student.domain.model.Student;

public interface StudentRepository {
    Student save(Student student);
}
