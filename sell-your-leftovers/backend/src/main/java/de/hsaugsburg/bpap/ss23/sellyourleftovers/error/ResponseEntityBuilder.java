package de.hsaugsburg.bpap.ss23.sellyourleftovers.error;

import org.springframework.http.ResponseEntity;

/**
 * This provides the functionality for building a ResponseEntity.
 */
public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
