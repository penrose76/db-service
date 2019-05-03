package andrzej.dbservice.repository;

import andrzej.dbservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByRole(String role);

}