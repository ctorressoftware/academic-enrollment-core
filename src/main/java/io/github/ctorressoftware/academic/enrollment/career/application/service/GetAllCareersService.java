package io.github.ctorressoftware.academic.enrollment.career.application.service;

import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getall.GetAllCareersResult;
import io.github.ctorressoftware.academic.enrollment.career.application.port.in.getall.GetAllCareersUseCase;
import io.github.ctorressoftware.academic.enrollment.career.application.port.out.CareerRepository;
import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCareersService implements GetAllCareersUseCase {

    private final CareerRepository repository;

    public GetAllCareersService(CareerRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAllCareersResult getAll() {
        List<Career> careers = repository.getAll();
        return new GetAllCareersResult(careers);
    }
}
