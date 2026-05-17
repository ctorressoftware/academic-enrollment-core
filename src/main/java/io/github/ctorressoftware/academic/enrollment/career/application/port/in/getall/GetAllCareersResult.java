package io.github.ctorressoftware.academic.enrollment.career.application.port.in.getall;

import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;

import java.util.List;

public record GetAllCareersResult(List<Career> careers) {}
