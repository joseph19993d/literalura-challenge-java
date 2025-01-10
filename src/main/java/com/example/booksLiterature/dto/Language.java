package com.example.booksLiterature.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {

    SPANISH("en"),
    ENGLISH("es"),
    FRENCH("fr"),
    UNKNOWN("unknown");  // Default value for invalid languages

    private final String value;

    Language(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Language fromValue(String value) {
        for (Language language : values()) {
            if (language.getValue().equalsIgnoreCase(value)) {
                return language;
            }
        }
        // If the value is invalid, return the default 'UNKNOWN'
        return UNKNOWN;
    }
}
