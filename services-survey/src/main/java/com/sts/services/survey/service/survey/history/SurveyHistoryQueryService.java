package com.sts.services.survey.service.survey.history;

import com.sts.services.survey.dto.SurveyHistoryQueryDto;

import java.util.List;

public interface SurveyHistoryQueryService {

    List<SurveyHistoryQueryDto> getSurveyHistories(String username);

}
