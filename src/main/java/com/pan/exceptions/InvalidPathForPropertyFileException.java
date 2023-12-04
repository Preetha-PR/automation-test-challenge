package com.pan.exceptions;
@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends InvalidPathForFilesException{
    public InvalidPathForPropertyFileException(String message) {
        super(message);
    }

    public InvalidPathForPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
