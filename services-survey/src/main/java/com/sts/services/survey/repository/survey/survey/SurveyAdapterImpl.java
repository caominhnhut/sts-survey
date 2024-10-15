package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.entity.SurveyEntity;
import com.sts.services.survey.service.survey.survey.SurveyAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SurveyAdapterImpl implements SurveyAdapter {

    @Autowired
    private SurveyJpaRepository surveyJpaRepository;
    @Autowired
    private SurveyMyBatisMapper surveyMyBatisMapper;

    @Override
    public Optional<SurveyEntity> findById(Long id) {
        return surveyJpaRepository.findById(id);
    }
}
