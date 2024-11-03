package com.sts.services.survey.validator;

import com.sts.services.survey.dto.SurveyUserSubmitRequestDto;
import com.sts.services.survey.dto.common.Error;
import com.sts.services.survey.factory.ValidationType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SurveyUserSubmitValidator implements Validator<SurveyUserSubmitRequestDto> {

    @Override
    public ValidationType getType() {
        return ValidationType.SURVEY_USER_SUBMIT;
    }

    @Override
    public List<Error> validate(SurveyUserSubmitRequestDto surveyUserSubmitRequestDto) {

        List<Error> errors = new ArrayList<>();

        // Placeholder
        // Some validation logic here

        return errors;
    }

}
