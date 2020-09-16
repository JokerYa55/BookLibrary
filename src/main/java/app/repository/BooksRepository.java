package app.repository;

import app.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface BooksRepository extends CrudRepository<Book, Long> {

    public List<Book> findByCategoryIdOrderByName(Long categoryId);

    public List<Book> findAllByOrderByName();
}
