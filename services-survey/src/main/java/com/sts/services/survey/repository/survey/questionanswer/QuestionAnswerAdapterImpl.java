package com.sts.services.survey.repository.survey.questionanswer;

import com.sts.services.survey.entity.QuestionAnswerEntity;
import com.sts.services.survey.service.survey.questionanswer.adapter.QuestionAnswerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionAnswerAdapterImpl implements QuestionAnswerAdapter {

    private final QuestionAnswerJpaRepository questionAnswerJpaRepository;

    @Override
    public List<QuestionAnswerEntity> getCorrectQuestionAnswers(Long surveyId) {
        return questionAnswerJpaRepository.getCorrectQuestionAnswers(surveyId);
    }

    @Override
    public List<QuestionAnswerEntity> findAll(List<Long> answerIds) {
        return questionAnswerJpaRepository.findAllById(answerIds);
    }

    @Override
    public List<QuestionAnswerEntity> saveAll(List<QuestionAnswerEntity> questionAnswerEntities) {
        return questionAnswerJpaRepository.saveAll(questionAnswerEntities);
    }

    @Override
    public void deleteAll(List<Long> questionAnswerIds) {
        questionAnswerJpaRepository.deleteAllById(questionAnswerIds);
    }
}
