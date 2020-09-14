package app.controllers;

import app.model.Books;
import app.model.Category;
import app.service.BookService;
import app.service.CategoryService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class RestApiController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/test")
    public String test() {
        return "test";
    }

    @GetMapping(path = "/book")
    public List<Books> getBook() {
        return bookService.getBooks();
    }

    @GetMapping(path = "/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
}
