package ml.penkisimtai.restJersey.repository;

import ml.penkisimtai.restJersey.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepositrory extends CrudRepository<Employee, Long> {
    Employee findPersonById(Long id);
    Employee findPersonByFirstName(String firstName);
    @Modifying
    @Transactional
    Employee deleteByFirstName(String firstName);
}
