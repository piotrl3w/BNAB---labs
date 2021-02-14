package pl.arsonproject.bnabd.bnabd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.arsonproject.bnabd.bnabd.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
