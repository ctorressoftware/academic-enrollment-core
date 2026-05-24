package io.github.ctorressoftware.academic.enrollment.courseoffering.application.service.state;

import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.state.getall.GetAllCourseStatesResult;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.in.state.getall.GetAllCourseStatesUseCase;
import io.github.ctorressoftware.academic.enrollment.courseoffering.application.port.out.CourseStateRepository;
import io.github.ctorressoftware.academic.enrollment.courseoffering.domain.model.CourseState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCourseStatesService implements GetAllCourseStatesUseCase {

    private final CourseStateRepository repository;

    public GetAllCourseStatesService(CourseStateRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAllCourseStatesResult getAll() {
        List<CourseState> states = repository.getAll();
        return new GetAllCourseStatesResult(states);
    }
}
