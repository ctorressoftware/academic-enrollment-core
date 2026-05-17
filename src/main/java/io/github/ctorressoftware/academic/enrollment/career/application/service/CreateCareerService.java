package io.github.ctorressoftware.academic.enrollment.career.application.service;

import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerCommand;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.create.CreateCareerUseCase;
import io.github.ctorressoftware.academic.enrollment.career.application.port.out.CareerRepository;
import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;
import org.springframework.stereotype.Service;

@Service
public class CreateCareerService implements CreateCareerUseCase {

    private final CareerRepository repository;

    public CreateCareerService(CareerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateCareerResult create(CreateCareerCommand command) {

        Career career = Career.create(
                command.code(),
                command.description()
        );

        Career saved = repository.save(career);

        return new CreateCareerResult(saved);
    }
}
