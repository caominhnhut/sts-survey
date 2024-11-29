package com.sts.services.survey.dto.common;

import lombok.Data;

@Data
public class Error {

    private String status;
    private String title;
    private String pointer;
    private String detail;

    public Error(String pointer, String detail) {
        this.pointer = pointer;
        this.detail = detail;
    }
}
