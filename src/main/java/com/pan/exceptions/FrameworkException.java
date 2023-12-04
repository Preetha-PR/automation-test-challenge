package com.pan.exceptions;
/**
 * BaseException for the framework. Extends Runtime Exception and can be thrown anywhere to terminate a program
 */
@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException{
    /**
     * Pass the message that needs to be appended to the stacktrace
     */
    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message,Throwable cause) {
        super(message,cause);
    }
}
