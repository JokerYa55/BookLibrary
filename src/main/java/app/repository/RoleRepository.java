package app.repository;

import app.model.Role;
import app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vasil
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    User findByName(String name);
}
