package org.exad.examenad_postgresql.exceptions;


public class ConnectionDbException extends RuntimeException {
    public ConnectionDbException(String message) {
        super(message);
    }
}
