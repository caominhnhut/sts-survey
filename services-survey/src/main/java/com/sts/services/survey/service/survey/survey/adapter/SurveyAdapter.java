package com.sts.services.survey.service.survey.survey.adapter;

import com.sts.services.survey.entity.SurveyEntity;

import java.util.Optional;

public interface SurveyAdapter {

    Optional<SurveyEntity> findById(Long id);

    SurveyEntity save(SurveyEntity surveyEntity);

}
