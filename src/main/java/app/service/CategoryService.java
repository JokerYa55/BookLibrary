package app.service;

import app.model.Category;
import app.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        List<Category> result = new ArrayList<>();
        categoryRepository.findAllByOrderByName().iterator().forEachRemaining((t) -> {
            result.add(t);
        });
        return result;
    }

}
