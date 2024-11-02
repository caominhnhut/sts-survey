package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;
import com.sts.services.survey.service.survey.survey.SurveyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurveyQueryServiceImpl implements SurveyQueryService {

    @Autowired
    private SurveyMyBatisMapper surveyMyBatisMapper;
    @Autowired
    private SurveyJpaRepository surveyJpaRepository;

    @Override
    public List<SurveyQueryDto> getSurveys() {
        return surveyMyBatisMapper.getSurveys();
    }

    @Override
    public SurveyQueryDto getSurveyDetails(Long surveyId) {
        return surveyMyBatisMapper.getSurveyDetails(surveyId);
    }

    @Override
    public SurveyQueryDto getSimpleSurveyDetails(Long surveyId) {
        return surveyMyBatisMapper.getSimpleSurveyDetails(surveyId);
    }
}
