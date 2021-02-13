package pl.arsonproject.bnabd.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arsonproject.bnabd.bnabd.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
