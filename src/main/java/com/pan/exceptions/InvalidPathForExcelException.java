package com.pan.exceptions;


/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 */
@SuppressWarnings("serial")

public class InvalidPathForExcelException extends InvalidPathForFilesException {

    public InvalidPathForExcelException(String message) {
        super(message);
    }

    public InvalidPathForExcelException(String message, Throwable cause) {
        super(message, cause);
    }
}
