package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SurveyMyBatisMapper {

    List<SurveyQueryDto> getSurveys(boolean activeOnly);

    SurveyQueryDto getSurveyDetails(Long surveyId);

    SurveyQueryDto getSurveyDetailsConfig(Long surveyId);
}
