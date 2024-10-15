package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.dto.SurveyHistoryQueryDto;
import com.sts.services.survey.service.survey.history.SurveyHistoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurveyHistoryQueryServiceImpl implements SurveyHistoryQueryService {

    @Autowired
    private SurveyHistoryMyBatisMapper surveyHistoryMyBatisMapper;
    @Autowired
    private SurveyHistoryJpaRepository surveyHistoryJpaRepository;

    @Override
    public List<SurveyHistoryQueryDto> getSurveyHistories(String username) {
        return surveyHistoryMyBatisMapper.getSurveyHistories(username);
    }
}
