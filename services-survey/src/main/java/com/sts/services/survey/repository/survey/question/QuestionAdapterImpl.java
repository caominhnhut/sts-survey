package com.sts.services.survey.repository.survey.question;

import com.sts.services.survey.entity.QuestionEntity;
import com.sts.services.survey.service.survey.question.QuestionAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionAdapterImpl implements QuestionAdapter {

    @Autowired
    private QuestionJpaRepository questionJpaRepository;

    @Override
    public List<QuestionEntity> findBySurveyId(Long surveyId) {
        return questionJpaRepository.findBySurveyId(surveyId);
    }
}
