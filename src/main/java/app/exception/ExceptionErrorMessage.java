package app.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vasil
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionErrorMessage {

    @SerializedName("code")
    @JsonProperty("code")
    int code;
    @JsonProperty("error_message")
    @SerializedName("error_message")
    String errorMessage;
}
