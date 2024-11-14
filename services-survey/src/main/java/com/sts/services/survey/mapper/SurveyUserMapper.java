package com.sts.services.survey.mapper;

import com.sts.services.survey.command.SurveyUserResultCommand;
import com.sts.services.survey.dto.SurveyUserSubmitRequestDto;
import com.sts.services.survey.dto.SurveyUserResultResponseDto;
import com.sts.services.survey.command.SurveyUserSubmitCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyUserMapper {

    SurveyUserSubmitCommand toSurveyUserSubmitCommand(SurveyUserSubmitRequestDto surveyUserSubmitRequestDto);

    SurveyUserResultResponseDto fromSurveyUserResultCommand(SurveyUserResultCommand surveyUserResultCommand);

}
