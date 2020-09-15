package app.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;

/**
 *
 * @author vasil
 */
@NoArgsConstructor
public abstract class AppAbstractException extends RuntimeException {

    public AppAbstractException(String string) {
        super(string);
    }

    public static String toJson(int code, String errorMessage) {
        Gson gson = new GsonBuilder().create();
        ExceptionErrorMessage error = new ExceptionErrorMessage(code, errorMessage);
        return gson.toJson(error);
    }

}
