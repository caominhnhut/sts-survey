package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.dto.SurveyQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SurveyMyBatisMapper {

    List<SurveyQueryDto> getSurveys();

    SurveyQueryDto getSurveyDetails(Long surveyId);

    @Select("SELECT survey_id AS id, name, description, perform_timeout, pass_correct_answer_number, status " +
            "FROM survey WHERE survey_id = #{survey_id}")
    SurveyQueryDto getSimpleSurveyDetails(Long surveyId);
}
