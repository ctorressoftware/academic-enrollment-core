package io.github.ctorressoftware.academic.enrollment.teacher.application.service;

import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherCommand;
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherResult;
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.in.create.CreateTeacherUseCase;
import io.github.ctorressoftware.academic.enrollment.teacher.application.port.out.TeacherRepository;
import io.github.ctorressoftware.academic.enrollment.teacher.domain.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateTeacherService implements CreateTeacherUseCase {

    private final TeacherRepository repository;

    public CreateTeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateTeacherResult create(CreateTeacherCommand command) {
        Objects.requireNonNull(command, "create teacher command is null");
        Teacher teacher = Teacher.create(command.personId());
        Teacher saved = repository.save(teacher);

        return new CreateTeacherResult(saved);
    }
}