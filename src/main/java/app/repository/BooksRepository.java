package app.repository;

import app.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface BooksRepository extends CrudRepository<Book, Long> {

}
