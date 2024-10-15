package com.sts.services.survey.service.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;

import java.util.List;

public interface SurveyQueryService {

    List<SurveyQueryDto> getSurveys();

    SurveyQueryDto getSimpleSurveyDetails(Long surveyId);
}
