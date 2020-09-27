
package app.repository;

import app.model.Trash;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface TrashRepository extends CrudRepository<Trash, Long>{
    
}
