package com.sts.services.survey.mapper;

import com.sts.services.survey.command.SurveyCreateCommand;
import com.sts.services.survey.entity.QuestionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionEntity toQuestionEntity(SurveyCreateCommand.QuestionCreateCommand questionCreateCommand);

}
