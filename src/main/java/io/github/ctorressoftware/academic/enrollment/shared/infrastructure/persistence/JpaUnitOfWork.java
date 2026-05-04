package io.github.ctorressoftware.academic.enrollment.shared.infrastructure.persistence;

import io.github.ctorressoftware.academic.enrollment.shared.application.port.out.UnitOfWork;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class JpaUnitOfWork implements UnitOfWork {

    private final EntityManager entityManager;

    public JpaUnitOfWork(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void flush() {
        entityManager.flush();
    }
}
