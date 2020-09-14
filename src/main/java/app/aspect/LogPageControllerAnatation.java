package app.aspect;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Аннотация для логгирования PageController
 *
 * @author Vasiliy.Andricov
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface LogPageControllerAnatation {

}
