package com.sts.services.survey.service.survey.question.adapter;

import com.sts.services.survey.entity.SurveyQuestionEntity;

import java.util.List;

public interface SurveyQuestionAdapter {

    List<SurveyQuestionEntity> saveAll(List<SurveyQuestionEntity> surveyQuestionEntity);

    SurveyQuestionEntity findBySurveyIdAndQuestionIds(Long surveyId, List<Long> questionIds);

    void deleteAll(List<Long> surveyQuestionId);

    void deleteAllBySurveyIdAndQuestionIds(Long surveyId, List<Long> questionIds);
}
