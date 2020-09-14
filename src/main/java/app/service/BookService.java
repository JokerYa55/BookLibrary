package app.service;

import app.model.Books;
import app.repository.BooksRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vasil
 */
@Service
public class BookService {

    @Autowired
    BooksRepository bookRepository;

    public List<Books> getBooks() {
        List<Books> result = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining((t) -> {
            result.add(t);
        });

        return result;
    }
}
