package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.entity.SurveyEntity;
import com.sts.services.survey.service.survey.survey.adapter.SurveyAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SurveyAdapterImpl implements SurveyAdapter {

    private final SurveyJpaRepository surveyJpaRepository;
    private final SurveyMyBatisMapper surveyMyBatisMapper;

    @Override
    public Optional<SurveyEntity> findById(Long id) {
        return surveyJpaRepository.findById(id);
    }

    @Override
    public SurveyEntity save(SurveyEntity surveyEntity) {
        return surveyJpaRepository.save(surveyEntity);
    }
}
