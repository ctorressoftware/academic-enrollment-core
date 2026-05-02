package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPersonRepository extends JpaRepository<PersonEntity, UUID> {}
