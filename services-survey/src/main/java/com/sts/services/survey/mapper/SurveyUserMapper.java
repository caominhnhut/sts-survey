package com.sts.services.survey.mapper;

import com.sts.services.survey.dto.SurveyUserSubmitRequestDto;
import com.sts.services.survey.dto.SurveyUserResultResponseDto;
import com.sts.services.survey.model.SurveyUserSubmit;
import com.sts.services.survey.model.SurveyUserResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyUserMapper {

    SurveyUserSubmit toSurveyUserSubmit(SurveyUserSubmitRequestDto surveyUserSubmitRequestDto);

    SurveyUserResultResponseDto fromSurveyUserResult(SurveyUserResult surveyUserResult);

}
