package com.sts.services.survey.service.survey.question;


import com.sts.services.survey.entity.QuestionEntity;

import java.util.List;

public interface QuestionAdapter {

    List<QuestionEntity> findBySurveyId(Long surveyId);

}
