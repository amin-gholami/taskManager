package amp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableErrorException extends RuntimeException {
    public ServiceUnavailableErrorException(String message) {
        super(message);
    }
}
