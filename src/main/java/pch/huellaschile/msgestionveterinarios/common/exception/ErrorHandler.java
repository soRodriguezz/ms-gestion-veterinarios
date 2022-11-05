package pch.huellaschile.msgestionveterinarios.common.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class ErrorHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    public ErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(VeterinarioNotExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(HttpServletRequest request,
                                                                  VeterinarioNotExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(VeterinariaExistException.class)
    public ResponseEntity<ErrorInfo> handleDuplicatedPetException(HttpServletRequest request,
                                                                  VeterinariaExistException ex, Locale locale) {
        ErrorInfo response = new ErrorInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale));
        return new ResponseEntity<>(response, HttpStatus.IM_USED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception ex, Locale locale) {
        String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        return new ResponseEntity<>(new ErrorInfo(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
