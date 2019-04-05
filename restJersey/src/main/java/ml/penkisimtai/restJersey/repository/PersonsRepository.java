package ml.penkisimtai.restJersey.repository;

import ml.penkisimtai.restJersey.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonsRepository extends CrudRepository<Person, Long> {
    Person findPersonById(Long id);
    Person findPersonByFirstName(String firstName);
    @Modifying
    @Transactional
    Integer deleteByFirstName(String firstName);
}
