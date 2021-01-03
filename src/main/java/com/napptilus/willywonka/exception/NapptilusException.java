package com.napptilus.willywonka.exception;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Napptilus Custom Exception
 */
public class NapptilusException extends Exception {

    /**
     * Default Serial ID
     */
    private static final long serialVersionUID = 345456L;

    /**
     * Default Constructor
     */
    public NapptilusException() {

    }

    /**
     * Parameterized Constructor
     * @param message string
     */
    public NapptilusException(String message) {
        super(message);
    }

    /**
     * Parameterized Constructor
     * @param cause throwable
     */
    public NapptilusException(Throwable cause) {
        super(cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param cause throwable
     */
    public NapptilusException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Parameterized Constructor
     * @param message string
     * @param error error
     */
    public NapptilusException(String message, Error error) {
        super(message, error);
    }
}
