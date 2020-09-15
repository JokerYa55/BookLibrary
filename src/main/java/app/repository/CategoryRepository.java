package app.repository;

import app.model.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vasil
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    public List<Category> findAllByOrderByName();
}
