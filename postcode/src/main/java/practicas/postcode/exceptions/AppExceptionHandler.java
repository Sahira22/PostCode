package practicas.postcode.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import practicas.postcode.models.responses.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler {
    
/**Puedes tener varias excepciones en un mismo metodo que dara un mismo mensaje.
 *  Si el resultado o mensaje que se desea dar para el error o la excepcion generada es diferente pues se utiliza diferentes metodos
 * Cristal Guerrero
 */
    @ExceptionHandler(value = { EmailExistsException.class })
    public ResponseEntity<Object> handleEmailExistsException(EmailExistsException ex, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(),2);/**Parametros que recibira la clase ErrorMessage */
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(),2);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


 
}
