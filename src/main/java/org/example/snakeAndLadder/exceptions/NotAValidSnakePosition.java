package org.example.snakeAndLadder.exceptions;

public class NotAValidSnakePosition extends RuntimeException{
    public NotAValidSnakePosition() {
    }

    public NotAValidSnakePosition(String message) {
        super(message);
    }

    public NotAValidSnakePosition(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAValidSnakePosition(Throwable cause) {
        super(cause);
    }

    public NotAValidSnakePosition(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
