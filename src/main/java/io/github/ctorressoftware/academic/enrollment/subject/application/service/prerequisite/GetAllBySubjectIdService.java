package io.github.ctorressoftware.academic.enrollment.subject.application.service.prerequisite;

import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid.GetAllBySubjectIdResult;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.in.prerequisite.getallbysubjectid.GetAllBySubjectIdUseCase;
import io.github.ctorressoftware.academic.enrollment.subject.application.port.out.PrerequisiteRepository;
import io.github.ctorressoftware.academic.enrollment.subject.domain.model.Prerequisite;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetAllBySubjectIdService implements GetAllBySubjectIdUseCase {

    private final PrerequisiteRepository repository;

    public GetAllBySubjectIdService(PrerequisiteRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAllBySubjectIdResult getAllBySubjectId(UUID subjectId) {
        List<Prerequisite> prerequisites = repository.findAllBySubjectId(subjectId);
        return new GetAllBySubjectIdResult(prerequisites);
    }
}
