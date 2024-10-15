package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.entity.SurveyHistoryEntity;
import com.sts.services.survey.service.survey.history.SurveyHistoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyHistoryAdapterImpl implements SurveyHistoryAdapter {

    @Autowired
    private SurveyHistoryJpaRepository surveyHistoryJpaRepository;
    @Autowired
    private SurveyHistoryMyBatisMapper surveyHistoryMyBatisMapper;

    @Override
    public SurveyHistoryEntity create(SurveyHistoryEntity surveyHistoryEntity) {
        return surveyHistoryJpaRepository.save(surveyHistoryEntity);
    }
}
