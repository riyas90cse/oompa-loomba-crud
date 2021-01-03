package com.napptilus.willywonka.exception;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Napptilus Custom Server Exception
 */
public class NapptilusServerException extends Exception {

    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 345456L;

    /**
     * Default Constructor
     */
    public NapptilusServerException() {

    }

    /**
     * Parameterized Constructor
     * @param message string
     */
    public NapptilusServerException(String message) {
        super(message);
    }

    /**
     * Parameterized Constructor
     * @param cause throwable
     */
    public NapptilusServerException(Throwable cause) {
        super(cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param cause throwable
     */
    public NapptilusServerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param error error
     */
    public NapptilusServerException(String message, Error error) {
        super(message, error);
    }
}
