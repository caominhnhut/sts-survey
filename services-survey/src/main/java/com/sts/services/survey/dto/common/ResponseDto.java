package com.sts.services.survey.dto.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ResponseDto<T>{

    private T data;

    private List<Error> errors;

    public static <T> ResponseDto<T> response(T data) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setData(data);
        return responseDto;
    }

    public static <T> ResponseDto<T> errorResponse(List<Error> errors) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setErrors(errors);
        return responseDto;
    }
}
