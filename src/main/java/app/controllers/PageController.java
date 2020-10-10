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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     *
     * @param model
     * @return
     */
    @GetMapping(path = "/registration", produces = "text/html")
    public String registration(Model model) {
        log.info(PagesType.REGISTRATION_PAGE.toString());
        return PagesType.REGISTRATION_PAGE.toString();
    }
    
    @PostMapping(path = "/registration", produces = "text/html")
    public String registrationPost(Model model, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("passwordConfirm") String passwordConfirm) {
        log.info(PagesType.REGISTRATION_PAGE.toString());
        log.info("username = {} password = {} passwordConfirm = {}", username, password, passwordConfirm);
        return PagesType.REGISTRATION_PAGE.toString();
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping(path = "/login", produces = "text/html")
    public String login(Model model) {
        log.info(PagesType.LOGIN_PAGE.toString());
        return PagesType.LOGIN_PAGE.toString();
    }

    /**
     *
     * @return
     */
    @ModelAttribute("title")
    public String titleMessage() {
        return "Библиотека";
    }
}
