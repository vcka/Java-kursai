package ml.penkisimtai.warehouse.repository;

import ml.penkisimtai.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    boolean existsByName(String name);

    @Modifying
    @Transactional
    boolean existsByDescription(String name);

}
