package com.sts.services.survey.repository.survey.question;

import com.sts.services.survey.entity.QuestionEntity;
import com.sts.services.survey.service.survey.question.adapter.QuestionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionAdapterImpl implements QuestionAdapter {

    private final QuestionJpaRepository questionJpaRepository;

    @Override
    public List<QuestionEntity> findBySurveyId(Long surveyId) {
        return questionJpaRepository.findBySurveyId(surveyId);
    }

    @Override
    public List<QuestionEntity> findAll(List<Long> questionIds) {
        return questionJpaRepository.findAllById(questionIds);
    }

    @Override
    public List<QuestionEntity> saveAll(List<QuestionEntity> questionEntities) {
        return questionJpaRepository.saveAll(questionEntities);
    }

}
