package app.configuration;

import app.model.Book;
import app.model.Category;
import app.model.Users;
import app.repository.BooksRepository;
import app.repository.CategoryRepository;
import app.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 *
 * @author Vasiliy.Andricov
 */
@Slf4j
@Configuration
public class ProjectConfiguration {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    UserRepository userRepository;

    /**
     *
     */
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("App started up");
        genTestData();
    }

    /**
     *
     */
    private void genTestData() {
        // Генерация категорий
        List<Category> categoryList = Arrays.asList(new Category("Фантастика"), 
                new Category("Поэзия"), 
                new Category("Приключения"), 
                new Category("Наука"),
                new Category("Спорт"),
                new Category("Советская проза"),
                new Category("Фентази"),
                new Category("Анимэ"),
                new Category("Зарубежная проза"));
        Category category = new Category("Afynfcnbrf");
        category.setName("test");
        categoryRepository.saveAll(categoryList);
        // Генерация пользователя
        List<Users> userList = Arrays.asList(new Users("admin", "Администратор", "123"), new Users("user_1", "Иванов Иван", "123"), new Users("user_2", "Петров Петр", "123"));
        userRepository.saveAll(userList);
        // Генерация книг
        List<Book> booksList = Arrays.asList(new Book("День триффидов", "978-5-17-095526-8", null, 1L), 
                new Book("Цена бессмертия. Наша старая добрая фантастика", "978-5-389-12663-3", null, 1L),
                new Book("Halo. Потоп", "978-5-389-17962-2", null, 1L),
                new Book("История будущего. Книга 2. Пасынки Вселенной", "978-5-389-16880-0", null, 1L));
        booksRepository.saveAll(booksList);

    }
}
