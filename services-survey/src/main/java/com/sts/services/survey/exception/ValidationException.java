package com.sts.services.survey.exception;

import lombok.Data;

@Data
public class ValidationException extends RuntimeException {

    private String pointer;

    public ValidationException(String pointer, String message) {
        super(message);
        this.pointer = pointer;
    }
}
