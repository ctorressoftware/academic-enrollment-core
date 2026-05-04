package io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.adapter;

import io.github.ctorressoftware.academic.enrollment.person.application.port.out.PersonRepository;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Document;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.DocumentType;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Email;
import io.github.ctorressoftware.academic.enrollment.person.domain.model.Person;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.entity.PersonEntity;
import io.github.ctorressoftware.academic.enrollment.person.infrastructure.persistence.repository.SpringDataPersonRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaPersonRepositoryAdapter implements PersonRepository {

    private final SpringDataPersonRepository repository;

    public JpaPersonRepositoryAdapter(SpringDataPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Person save(Person person) {
        PersonEntity saved = repository.save(toEntity(person));
        return toDomain(saved);
    }

    private Person toDomain(PersonEntity entity) {

        Document document = new Document(
                DocumentType.getById(entity.getDocumentTypeId()),
                entity.getDocumentNumber()
        );

        return Person.restore(
                entity.getId(),
                entity.getFirstName(),
                entity.getMiddleName(),
                entity.getLastName(),
                entity.getSecondLastName(),
                document,
                entity.getGenderId(),
                new Email(entity.getEmail()),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    private PersonEntity toEntity(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setMiddleName(person.getMiddleName());
        entity.setLastName(person.getLastName());
        entity.setSecondLastName(person.getSecondLastName());
        entity.setDocumentTypeId(person.getDocument().type().getId());
        entity.setDocumentNumber(person.getDocument().value());
        entity.setGenderId(person.getGenderId());
        entity.setEmail(person.getEmail().value());
        entity.setActive(person.isActive());
        entity.setCreatedAt(person.getCreatedAt());
        entity.setUpdatedAt(person.getUpdatedAt());
        return entity;
    }
}
