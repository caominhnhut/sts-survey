package com.sts.services.survey.service.survey.questionanswer;

import com.sts.services.survey.entity.QuestionAnswerEntity;

import java.util.List;

public interface QuestionAnswerAdapter {

    List<QuestionAnswerEntity> getCorrectQuestionAnswers(Long surveyId);

}
