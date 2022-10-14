package amp.exceptions;

import amp.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Response<String>> unauthorizedExceptionHandle(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new Response<String>()
                .setStatus(401),
                HttpStatus.UNAUTHORIZED);

    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response<String>> badRequestHandler(BadRequestException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new Response<String>()
                .setStatus(400),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response<String>> notFoundExceptionHandler(NotFoundException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new Response<String>()
                .setStatus(404),
                HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ServiceUnavailableErrorException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ResponseEntity<Response<String>> ServiceUnavailableErrorException(ServiceUnavailableErrorException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new Response<String>()
                .setStatus(503),
                HttpStatus.SERVICE_UNAVAILABLE);

    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Response<String>> ServerExceptionHandler(InternalServerException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new Response<String>()
                .setStatus(500),
                HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
