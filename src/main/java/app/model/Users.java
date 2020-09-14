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
@Table(name = "t_users")
@NoArgsConstructor
public class Users {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String fio;
    @Column(name = "password_hash")
    @JsonProperty("password_hash")
    String passwordHash;

    public Users(String username, String fio, String passwordHash) {
        this.username = username;
        this.fio = fio;
        this.passwordHash = passwordHash;
    }

}
