package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.dto.SurveyHistoryQueryDto;
import com.sts.services.survey.service.survey.history.SurveyHistoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyHistoryQueryServiceImpl implements SurveyHistoryQueryService {

    private final SurveyHistoryMyBatisMapper surveyHistoryMyBatisMapper;
    private final SurveyHistoryJpaRepository surveyHistoryJpaRepository;

    @Override
    public List<SurveyHistoryQueryDto> getSurveyHistories(String username) {
        return surveyHistoryMyBatisMapper.getSurveyHistories(username);
    }
}
