package ml.penkisimtai.restJersey.repository;

import ml.penkisimtai.restJersey.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Long> {
    Person findPersonById(Long id);
}
