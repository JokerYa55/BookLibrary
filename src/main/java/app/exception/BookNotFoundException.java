package app.exception;

/**
 *
 * @author vasil
 */
public class BookNotFoundException extends AppAbstractException {

    private static final int CODE = 1004;
    private static final String ERROR_MESSAGE = "book not found";

    public BookNotFoundException() {
        super(toJson(CODE, ERROR_MESSAGE));
    }

    public BookNotFoundException(String message) {
        super(toJson(CODE, message));
    }

}
