package com.sts.services.survey.validator;

import java.util.List;

import com.sts.services.survey.dto.common.Error;
import com.sts.services.survey.factory.ValidationType;

public interface Validator<T>{

    ValidationType getType();

    List<Error> validate(T data);
}
