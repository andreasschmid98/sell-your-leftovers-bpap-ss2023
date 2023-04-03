package de.hsaugsburg.bpap.ss23.sellyourleftovers.error.exception;

/**
 * This defines the exception for the following error:
 * Users can not register with this email because there already exists an user
 * with this email.
 */
public class EmailAlreadyTakenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public EmailAlreadyTakenException(String message) {
        super(message);
    }
}

