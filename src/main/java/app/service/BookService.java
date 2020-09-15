package app.service;

import app.exception.BookNotFoundException;
import app.model.Book;
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

    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining((t) -> {
            result.add(t);
        });

        return result;
    }

    public byte[] getBooksImage(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException());
        return book.getCoverImage();
    }
}
