package apiotrowska.primenumbers.exceptionHandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class CustomExceptionHandlerResolver extends DefaultHandlerExceptionResolver {
    @ExceptionHandler(value= MethodArgumentTypeMismatchException.class)
    public String invalidValueHandler(Model model) {
        model.addAttribute("error", "Boundary should be a number");
        return "home";
    }

    @ExceptionHandler(value = NegativeArraySizeException.class)
    public String negativeValueHandler(Model model) {
        model.addAttribute("error", "Boundary can not be a negative number");
        return "home";
    }
}
