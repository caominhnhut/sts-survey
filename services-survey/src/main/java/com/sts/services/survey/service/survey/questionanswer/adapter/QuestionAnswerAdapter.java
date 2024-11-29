package com.sts.services.survey.service.survey.questionanswer.adapter;

import com.sts.services.survey.entity.QuestionAnswerEntity;

import java.util.List;

public interface QuestionAnswerAdapter {

    List<QuestionAnswerEntity> getCorrectQuestionAnswers(Long surveyId);

    List<QuestionAnswerEntity> findAll(List<Long> answerIds);

    List<QuestionAnswerEntity> saveAll(List<QuestionAnswerEntity> questionAnswerEntities);

    void deleteAll(List<Long> questionAnswerIds);
}
