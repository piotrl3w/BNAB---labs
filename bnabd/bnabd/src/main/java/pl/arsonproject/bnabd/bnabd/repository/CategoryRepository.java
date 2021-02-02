package pl.arsonproject.bnabd.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arsonproject.bnabd.bnabd.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
