package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "isdn")
    String isdn;
    @Column(name = "image")
    @JsonProperty("image")
    byte[] coverImage;
    @JsonProperty("category_id")
    @Column(name = "category_id")
    Long categoryId;

    public Book(String name, String isdn, byte[] coverImage, Long categoryId) {
        this.name = name;
        this.isdn = isdn;
        this.coverImage = coverImage;
        this.categoryId = categoryId;
    }

}
