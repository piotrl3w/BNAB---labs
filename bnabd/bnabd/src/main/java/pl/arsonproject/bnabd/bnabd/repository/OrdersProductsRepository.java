package pl.arsonproject.bnabd.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arsonproject.bnabd.bnabd.model.OrderProducts;

public interface OrdersProductsRepository extends JpaRepository<OrderProducts,Long> {
}
