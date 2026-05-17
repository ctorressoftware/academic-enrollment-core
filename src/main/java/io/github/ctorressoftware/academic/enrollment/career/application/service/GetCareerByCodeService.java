package io.github.ctorressoftware.academic.enrollment.career.application.service;

import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getbycode.GetCareerByCodeResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getbycode.GetCareerByCodeUseCase;
import io.github.ctorressoftware.academic.enrollment.career.application.port.out.CareerRepository;
import io.github.ctorressoftware.academic.enrollment.career.domain.exception.CareerNotFoundException;
import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCareerByCodeService implements GetCareerByCodeUseCase {

    private final CareerRepository repository;

    public GetCareerByCodeService(CareerRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetCareerByCodeResult getByCode(String code) {

        Career career = repository.getByCode(code)
                .orElseThrow(() -> new CareerNotFoundException(code));

        return new GetCareerByCodeResult(career);
    }
}
