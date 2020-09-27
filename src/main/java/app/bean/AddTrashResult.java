package app.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author vasil
 */
@AllArgsConstructor
@NoArgsConstructor
public class AddTrashResult {

    @JsonProperty("book_id")
    Long bookId;
}
