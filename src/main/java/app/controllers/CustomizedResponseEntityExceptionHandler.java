package app.controllers;

import app.exception.BookNotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Обработчик исключений приложения
 *
 * @author Vasiliy.Andricov
 */
@ControllerAdvice
//@RestController
@Slf4j
public class CustomizedResponseEntityExceptionHandler {

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({BookNotFoundException.class})
    public final ResponseEntity handleParamNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
//
//    /**
//     *
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler({DefaultException.class})
//    public final ResponseEntity handleDefoultException(Exception ex, WebRequest request) {
//        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    /**
//     * Метод обрабатывает исключение UserAuthException и переадресует на
//     * страницу авторизации SSO
//     *
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler({UserAuthException.class})
//    public final ResponseEntity handleAuthException(Exception ex, WebRequest request) {
//        return new ResponseEntity(ex.getMessage(), HttpStatus.UNAUTHORIZED);
//    }
//
//    /**
//     * Метод обрабатывает все исключения валидации
//     *
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler({org.springframework.web.bind.MethodArgumentNotValidException.class})
//    public final ResponseEntity handleValidateException(Exception ex, WebRequest request) {
//        ExtendedError error = new ExtendedError(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value());
//        return new ResponseEntity(error, HttpStatus.METHOD_NOT_ALLOWED);
//    }
}
