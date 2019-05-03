package andrzej.dbservice.repository;

import andrzej.dbservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);
    List<User> findAll();
}
