package com.sts.services.survey.service.survey.question.adapter;


import com.sts.services.survey.entity.QuestionEntity;

import java.util.List;

public interface QuestionAdapter {

    List<QuestionEntity> findBySurveyId(Long surveyId);

    List<QuestionEntity> findAll(List<Long> questionIds);

    List<QuestionEntity> saveAll(List<QuestionEntity> questionEntities);

}
