package app.repository;

import app.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
