package com.sts.services.survey.repository.survey.questionanswer;

import com.sts.services.survey.entity.QuestionAnswerEntity;
import com.sts.services.survey.service.survey.questionanswer.QuestionAnswerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionAnswerAdapterImpl implements QuestionAnswerAdapter {

    @Autowired
    private QuestionAnswerJpaRepository questionAnswerJpaRepository;

    @Override
    public List<QuestionAnswerEntity> getCorrectQuestionAnswers(Long surveyId) {
        return questionAnswerJpaRepository.getCorrectQuestionAnswers(surveyId);
    }
}
