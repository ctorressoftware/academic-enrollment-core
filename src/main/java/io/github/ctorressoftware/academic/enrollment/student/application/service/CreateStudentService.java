package io.github.ctorressoftware.academic.enrollment.student.application.service;

import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentCommand;
import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentResult;
import io.github.ctorressoftware.academic.enrollment.student.application.port.in.create.CreateStudentUseCase;
import io.github.ctorressoftware.academic.enrollment.student.application.port.out.StudentRepository;
import io.github.ctorressoftware.academic.enrollment.student.domain.model.Student;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateStudentService implements CreateStudentUseCase {

    private final StudentRepository repository;

    public CreateStudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateStudentResult create(CreateStudentCommand command) {
        Objects.requireNonNull(command, "create student command is null");
        Student student = Student.create(command.personId(), command.careerId());
        Student saved = repository.save(student);

        return new CreateStudentResult(saved);
    }
}
