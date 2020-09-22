package app.controllers;

import app.service.BookService;
import app.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author vasil
 */
@Controller
@Slf4j
public class PageController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    BookService bookService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping(path = "/index", produces = "text/html")
    public String page(Model model) {
        log.info(PagesType.INDEX_PAGE.toString());
        model.addAttribute("categoryList", categoryService.getCategory());
        model.addAttribute("bookList", bookService.getBooks());
        return PagesType.INDEX_PAGE.toString();
    }

    /**
     *
     * @param model
     * @param categoryId
     * @return
     */
    @GetMapping(path = "/index/{category_id}", produces = "text/html")
    public String pageCategory(Model model, @PathVariable(name = "category_id") Long categoryId) {
        log.info(PagesType.INDEX_PAGE.toString());
        model.addAttribute("categoryList", categoryService.getCategory());
        model.addAttribute("bookList", bookService.getBooksByCategory(categoryId));
        return PagesType.INDEX_PAGE.toString();
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping(path = "/trash", produces = "text/html")
    public String trash(Model model) {
        log.info(PagesType.TRASH_PAGE.toString());
        return PagesType.TRASH_PAGE.toString();
    }

    @ModelAttribute("title")
    public String titleMessage() {
        return "Библиотека";
    }
}
