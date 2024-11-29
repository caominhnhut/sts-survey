package com.sts.services.survey.config;

import com.sts.services.survey.dto.common.Error;
import com.sts.services.survey.dto.common.ResponseDto;
import com.sts.services.survey.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDto<?> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        log.error("MethodArgumentNotValidException");
        return ResponseDto.errorResponse(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDto<?> onConstraintValidationException(ConstraintViolationException e) {
        List<Error> errors = new ArrayList<>();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            String[] fullPath = violation.getPropertyPath().toString().split("\\.");
            log.error(Arrays.toString(fullPath));
            String fieldPath = fullPath[fullPath.length - 1];
            errors.add(new Error(fieldPath, violation.getMessage()));
        }
        log.error("ConstraintViolationException");
        return ResponseDto.errorResponse(errors);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseDto<?> onValidationException(ValidationException e) {
        log.error("ValidationException");
        return ResponseDto.errorResponse(List.of(new Error(e.getPointer(), e.getMessage())));
    }

}
