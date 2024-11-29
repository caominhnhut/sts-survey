package com.sts.services.survey.repository.survey.question;

import com.sts.services.survey.entity.SurveyQuestionEntity;
import com.sts.services.survey.service.survey.question.adapter.SurveyQuestionAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyQuestionAdapterImpl implements SurveyQuestionAdapter {

    private final SurveyQuestionJpaRepository surveyQuestionJpaRepository;

    public List<SurveyQuestionEntity> saveAll(List<SurveyQuestionEntity> surveyQuestionEntity) {
        return surveyQuestionJpaRepository.saveAll(surveyQuestionEntity);
    }

    @Override
    public SurveyQuestionEntity findBySurveyIdAndQuestionIds(Long surveyId, List<Long> questionIds) {
        return null;
    }

    @Override
    public void deleteAll(List<Long> surveyQuestionId) {
        surveyQuestionJpaRepository.deleteAllById(surveyQuestionId);
    }

    @Override
    public void deleteAllBySurveyIdAndQuestionIds(Long surveyId, List<Long> questionIds) {
        surveyQuestionJpaRepository.deleteAllBySurveyIdAndQuestionIdIn(surveyId, questionIds);
    }
}
