package ma.mundia.jpaap.repositories;

import ma.mundia.jpaap.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
