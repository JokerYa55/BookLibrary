package app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vasil
 */
@Controller
@Slf4j
public class PageController {

    /**
     * 
     * @param model
     * @return 
     */
    @GetMapping(path = "/index", produces = "text/html")
    public String page(Model model) {
        log.info(PagesType.INDEX_PAGE.toString());
        model.addAttribute("title", "Библиотека");
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
        model.addAttribute("title", "Библиотека");
        return PagesType.TRASH_PAGE.toString();
    }
}