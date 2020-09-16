package app.configuration;

import app.model.Book;
import app.model.Category;
import app.model.Users;
import app.repository.BooksRepository;
import app.repository.CategoryRepository;
import app.repository.UserRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
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
    public void doSomethingAfterStartup() throws FileNotFoundException, IOException {
        log.info("App started up");
        genTestData();
    }

    /**
     *
     */
    private void genTestData() throws FileNotFoundException, IOException {
        List<byte[]> images = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            File file = new File(getClass().getResource("/static/img/" + (i + 1) + ".jpg").getFile());
            byte[] image = Files.readAllBytes(file.toPath());
            images.add(image);
        }

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
        List<Book> booksList = Arrays.asList(new Book("День триффидов", "978-5-17-095526-8", images.get(0), 1L),
                new Book("Цена бессмертия. Наша старая добрая фантастика", "978-5-389-12663-3", images.get(1), 1L),
                new Book("Halo. Потоп", "978-5-389-17962-2", images.get(2), 1L),
                new Book("История будущего. Книга 2. Пасынки Вселенной", "978-5-389-16880-0", images.get(3), 1L),
                new Book("Расширенная Вселенная", "978-5-389-15852-8", images.get(4), 1L),
                new Book("Хроники Черного Отряда. Портал Теней", "978-5-389-17122-0", images.get(5), 1L),
                new Book("Карп и дракон. Книга 2. Рассказы ночной стражи", "978-5-389-18316-2", images.get(6), 1L),
                new Book("Фантастическая сага", "978-5-389-18245-5", images.get(7), 1L),
                new Book("Мстительница", "978-5-389-16902-9", images.get(8), 1L),
                new Book("Медленные пули", "978-5-389-17159-6", images.get(9), 1L));
        booksRepository.saveAll(booksList);

    }
}
