package com.example.booksLiterature.exeption;

public class DataConversionException extends RuntimeException {
    public DataConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}