package de.hsaugsburg.bpap.ss23.sellyourleftovers.error;

import de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception.EmailAlreadyTakenException;
import de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This provides the functionality for exception handling for all API-endpoints.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException exception) {

        List<String> details = new ArrayList<>();
        details.add(exception.getMessage());

        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .message("Resource Not Found")
                .errors(details)
                .build();

        return ResponseEntityBuilder.build(apiError);
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<Object> handleEmailAlreadyTakenException(
            EmailAlreadyTakenException exception) {

        List<String> details = new ArrayList<>();
        details.add(exception.getMessage());

        ApiError apiError = ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .message("Email already taken")
                .errors(details)
                .build();

        return ResponseEntityBuilder.build(apiError);
    }

}
