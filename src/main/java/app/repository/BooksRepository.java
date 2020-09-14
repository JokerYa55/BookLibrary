package app.repository;

import app.model.Books;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface BooksRepository extends CrudRepository<Books, Long> {

}
