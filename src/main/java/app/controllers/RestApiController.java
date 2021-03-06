package app.controllers;

import app.model.Book;
import app.model.Category;
import app.service.BookService;
import app.service.CategoryService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     *
     * @return
     */
    @GetMapping(path = "/test")
    public String test() {
        return "test";
    }

    /**
     *
     * @return
     */
    @GetMapping(path = "/book")
    public List<Book> getBook() {
        return bookService.getBooks();
    }

    /**
     *
     * @param response
     * @param bookId
     * @throws IOException
     */
    @GetMapping(path = "/book/{id}/img")
    public void getBookImage(HttpServletResponse response, @PathVariable(name = "id") Long bookId) throws IOException {
        response.setContentType("image/jpeg");
        byte[] buffer = bookService.getBooksImage(bookId);
        InputStream in1 = new ByteArrayInputStream(buffer);
        IOUtils.copy(in1, response.getOutputStream());

    }

    @GetMapping(path = "/book/{id}/load")
    public ResponseEntity<InputStreamResource> loadBookFile(HttpServletResponse response, @PathVariable(name = "id") Long bookId) throws IOException {
        response.setContentType("image/jpeg");
        byte[] buffer = bookService.getBooksImage(bookId);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(buffer));
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=test")
                // Content-Type
                .contentType(MediaType.APPLICATION_PDF)
                // Contet-Length
                .contentLength(buffer.length) //
                .body(resource);
    }

    /**
     *
     * @return
     */
    @GetMapping(path = "/category")
    public List<Category> getCategory() {
        return categoryService.getCategory();
    }
}
