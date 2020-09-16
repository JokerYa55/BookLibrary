package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vasil
 */
@Entity
@Data
@Table(name = "t_books")
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "isdn")
    private String isdn;
    @Column(name = "image")
    @JsonProperty("image")
    private byte[] coverImage;
    @JsonProperty("category_id")
    @Column(name = "category_id")
    private Long categoryId;
    @JsonProperty("author_id")
    @ManyToOne
    private Author author;
    @JsonProperty("book_load_count")
    @Column(name = "book_load_count")
    private Long bookLoad;
    @JsonProperty("book_show_count")
    @Column(name = "book_show_count")
    private Long bookShow;

    public Book(String name, String isdn, byte[] coverImage, Long categoryId, Author author) {
        this.name = name;
        this.isdn = isdn;
        this.coverImage = coverImage;
        this.categoryId = categoryId;
        this.author = author;
        this.bookLoad = 0L;
        this.bookShow = 0L;
    }

}
