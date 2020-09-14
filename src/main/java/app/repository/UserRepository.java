package app.repository;

import app.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface UserRepository extends CrudRepository<Users, Long> {

}
