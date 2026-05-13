package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository;

import io.github.ctorressoftware.academic.enrollment.person.domain.model.gender.Gender;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataGenderRepository
        extends JpaRepository<GenderEntity, Short> {

    List<GenderEntity> getAllByCode(String code);

    List<GenderEntity> getAllByCodeAndActiveIsTrue(String code);

    @Modifying
    @Query("""
            update gender set
              code = :code,
              description = :description,
              active = :active,
              updatedAt = :updatedAt
              where id = :id
            """)
    GenderEntity update(
            @Param("id") short id,
            @Param("code") String code,
            @Param("description") String description,
            @Param("active") boolean active,
            @Param("updatedAt") Instant updatedAt
    );

    void removeById(Short id);

    Optional<Gender> getByCode(String code);
}