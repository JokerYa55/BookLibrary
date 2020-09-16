package app.repository;

import app.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vasil
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}
