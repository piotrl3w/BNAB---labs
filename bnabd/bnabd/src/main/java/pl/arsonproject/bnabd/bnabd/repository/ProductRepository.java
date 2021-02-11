package pl.arsonproject.bnabd.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arsonproject.bnabd.bnabd.model.Category;
import pl.arsonproject.bnabd.bnabd.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}

