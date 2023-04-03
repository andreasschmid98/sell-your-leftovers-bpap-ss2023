package de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception;

/**
 * This defines the exception for the following error:
 * A given resource does not exist. Therefore, it can not be found.
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
