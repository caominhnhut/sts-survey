package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.entity.SurveyHistoryEntity;
import com.sts.services.survey.service.survey.history.adapter.SurveyHistoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SurveyHistoryAdapterImpl implements SurveyHistoryAdapter {

    private final SurveyHistoryJpaRepository surveyHistoryJpaRepository;
    private final SurveyHistoryMyBatisMapper surveyHistoryMyBatisMapper;

    @Override
    public SurveyHistoryEntity create(SurveyHistoryEntity surveyHistoryEntity) {
        return surveyHistoryJpaRepository.save(surveyHistoryEntity);
    }
}
