package io.obelus.model;

import lombok.Getter;

/**
 *
 */
@Getter
public abstract class ObelusException extends Exception {

    private String code;
    private Integer statusCode;

    public ObelusException(String message) {
        this(message, null, 0);
    }

    public ObelusException(String message, String code, int statusCode) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
    }

}
