package com.sts.services.survey.service.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;

import java.util.List;

public interface SurveyQueryService {

    List<SurveyQueryDto> getSurveys(boolean activeOnly);

    SurveyQueryDto getSurveyDetails(Long surveyId);

    SurveyQueryDto getSurveyDetailsConfig(Long surveyId);
}
