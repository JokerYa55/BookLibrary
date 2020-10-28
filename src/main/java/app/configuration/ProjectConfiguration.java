package app.configuration;

import app.model.Author;
import app.model.Book;
import app.model.Category;
import app.model.Role;
import app.model.User;
import app.repository.AuthorRepository;
import app.repository.BooksRepository;
import app.repository.CategoryRepository;
import app.repository.RoleRepository;
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

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    RoleRepository roleRepository;

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
        for (int i = 0; i < 19; i++) {
            File file = new File(getClass().getResource("/static/img/" + (i + 1) + ".jpg").getFile());
            byte[] image = Files.readAllBytes(file.toPath());
            images.add(image);
        }

        // Генерация авторов
        List<Author> authorList = Arrays.asList(new Author(null, "Гарри Гаррисон"),
                new Author(null, "Уильям Дитц"),
                new Author(null, "Уиндем Джон"),
                new Author(null, "Роберт Хайнлайн"),
                new Author(null, "Аластер Рейнольдс"),
                new Author(null, "Глен Кук"),
                new Author(null, "Ли Бардуго"),
                new Author(null, "Роберт Джордан"),
                new Author(null, "Анджей Сапковский"),
                new Author(null, "Филип Пулман"),
                new Author(null, "Симона Сент-Джеймс"),
                new Author(null, "Вячеслав Прах"),
                new Author(null, "Елена Ярышевская"),
                new Author(null, "Джейсон Вумек"),
                new Author(null, "Филипп Оклер")
        );

        authorRepository.saveAll(authorList);

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
        List<User> userList = Arrays.asList(new User("admin", "Администратор", "123"), new User("user_1", "Иванов Иван", "123"), new User("user_2", "Петров Петр", "123"));
        userRepository.saveAll(userList);
        // Генерация книг
        List<Book> booksList = Arrays.asList(new Book("День триффидов", "978-5-17-095526-8", images.get(0), 1L, authorList.get(2)),
                new Book("Цена бессмертия. Наша старая добрая фантастика", "978-5-389-12663-3", images.get(1), 1L, null),
                new Book("Halo. Потоп", "978-5-389-17962-2", images.get(2), 1L, authorList.get(1)),
                new Book("История будущего. Книга 2. Пасынки Вселенной", "978-5-389-16880-0", images.get(3), 1L, authorList.get(3)),
                new Book("Расширенная Вселенная", "978-5-389-15852-8", images.get(4), 1L, authorList.get(3)),
                new Book("Хроники Черного Отряда. Портал Теней", "978-5-389-17122-0", images.get(5), 1L, authorList.get(5)),
                new Book("Карп и дракон. Книга 2. Рассказы ночной стражи", "978-5-389-18316-2", images.get(6), 1L, null),
                new Book("Фантастическая сага", "978-5-389-18245-5", images.get(7), 1L, authorList.get(0)),
                new Book("Мстительница", "978-5-389-16902-9", images.get(8), 1L, authorList.get(4)),
                new Book("Медленные пули", "978-5-389-17159-6", images.get(9), 1L, authorList.get(4)),
                new Book("Чудо-Женщина. Вестница войны", "978-5-17-105902-6", images.get(10), 8L, authorList.get(6)),
                new Book("Колесо Времени. Книга 1. Око Мира", "978-5-389-17371-2", images.get(11), 3L, authorList.get(7)),
                new Book("Последнее желание. Меч предназначения", "978-5-17-118208-3", images.get(12), 7L, authorList.get(8)),
                new Book("Северное сияние", "978-5-17-120761-8", images.get(13), 7L, authorList.get(9)),
                new Book("Сломанные девочки", "978-5-00131-160-7", images.get(14), 9L, authorList.get(10)),
                new Book("Слова, которые нам не говорили родители", "978-5-17-121109-7", images.get(15), 6L, authorList.get(11)),
                new Book("Вышел пудель погулять", "978-5-17-121109-7", images.get(16), 2L, authorList.get(12)),
                new Book("Поднимая планку. Как работать эффективнее, мыслить масштабнее и успевать больше", "978-5-91657-962-8", images.get(17), 4L, authorList.get(13)),
                new Book("Тьерри Анри: одинокий на вершине", "978-5-04-088808-5", images.get(18), 5L, authorList.get(14)));
        booksRepository.saveAll(booksList);

        List<Role> roleList = Arrays.asList(new Role(1L, "ADMIN"), new Role(2L, "USER"));
        roleRepository.saveAll(roleList);

    }
}
