package com.pan.exceptions;
/**
 * Runtime Exception occurs when the key or value fetched from the property file is null
 *  */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException {

    public PropertyFileUsageException(String message) {
        super(message);
    }

    public PropertyFileUsageException(String message, Throwable cause) {
        super(message, cause);
    }
}