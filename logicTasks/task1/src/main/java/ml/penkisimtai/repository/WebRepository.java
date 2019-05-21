package ml.penkisimtai.repository;

import ml.penkisimtai.module.Input;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface WebRepository extends JpaRepository<Input, Long> {

    boolean existsByInput(String input);
}
