package io.github.ctorressoftware.academic.enrollment.career.infrastructure.web.response;

import io.github.ctorressoftware.academic.enrollment.career.domain.model.Career;

import java.util.List;

public record GetAllCareersResponse(List<Career> careers) {}
