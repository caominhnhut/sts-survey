package com.sts.services.survey.service.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;

import java.util.List;

public interface SurveyQueryService {

    List<SurveyQueryDto> getSurveys();

    SurveyQueryDto getSurveyDetails(Long surveyId);

    SurveyQueryDto getSimpleSurveyDetails(Long surveyId);
}
