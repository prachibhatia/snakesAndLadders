package org.example.snakeAndLadder.exceptions;

public class NotAValidLadderPosition extends RuntimeException{
    public NotAValidLadderPosition() {
    }

    public NotAValidLadderPosition(String message) {
        super(message);
    }

    public NotAValidLadderPosition(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAValidLadderPosition(Throwable cause) {
        super(cause);
    }

    public NotAValidLadderPosition(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
