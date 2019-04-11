package ml.penkisimtai.repository;

import ml.penkisimtai.module.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebRepository extends JpaRepository<Input, Long> {
}
