package com.sts.services.survey.mapper;

import com.sts.services.survey.command.SurveyCreateCommand;
import com.sts.services.survey.command.SurveyUpdateCommand;
import com.sts.services.survey.dto.SurveyCreateDto;
import com.sts.services.survey.dto.SurveyUpdateDto;
import com.sts.services.survey.entity.SurveyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    SurveyCreateCommand toSurveyCreateCommand(SurveyCreateDto surveyCreateDto);

    SurveyEntity toSurveyEntity(SurveyCreateCommand surveyCreateCommand);

    SurveyUpdateCommand toSurveyUpdateCommand(SurveyUpdateDto surveyUpdateDto);

}
