package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.dto.SurveyHistoryQueryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SurveyHistoryMyBatisMapper {

    @Select("SELECT survey_history_id AS id, survey_id, username, submit_date, total_question, pass_correct_answer_number, " +
            "cover_correct_answer_number, pass_percentage, cover_percentage, result " +
            "FROM survey_history WHERE username = #{username}")
    List<SurveyHistoryQueryDto> getSurveyHistories(String username);

}
