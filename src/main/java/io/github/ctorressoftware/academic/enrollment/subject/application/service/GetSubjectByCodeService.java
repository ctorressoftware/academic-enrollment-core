package io.github.ctorressoftware.academic.enrollment.subject.application.service;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode.GetSubjectByCodeCommand;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode.GetSubjectByCodeResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.getByCode.GetSubjectByCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.SubjectRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.exception.SubjectNotFoundException;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Subject;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GetSubjectByCodeService implements GetSubjectByCodeUseCase {

    private final SubjectRepository repository;

    public GetSubjectByCodeService(SubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetSubjectByCodeResult getByCode(GetSubjectByCodeCommand command) {
        Objects.requireNonNull(command, "command is null");

        Subject subject = repository.findByCode(command.code())
                .orElseThrow(() -> new SubjectNotFoundException(command.code()));

        return new GetSubjectByCodeResult(subject);
    }
}
