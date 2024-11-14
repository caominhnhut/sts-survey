package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;
import com.sts.services.survey.service.survey.survey.SurveyQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SurveyQueryServiceImpl implements SurveyQueryService {

    private final SurveyMyBatisMapper surveyMyBatisMapper;
    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public List<SurveyQueryDto> getSurveys(boolean activeOnly) {
        return surveyMyBatisMapper.getSurveys(activeOnly);
    }

    @Override
    public SurveyQueryDto getSurveyDetails(Long surveyId) {
        return surveyMyBatisMapper.getSurveyDetails(surveyId);
    }

    @Override
    public SurveyQueryDto getSurveyDetailsConfig(Long surveyId) {
        return surveyMyBatisMapper.getSurveyDetailsConfig(surveyId);
    }
}
