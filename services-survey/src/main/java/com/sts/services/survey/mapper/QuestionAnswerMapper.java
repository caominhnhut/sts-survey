package com.sts.services.survey.mapper;

import com.sts.services.survey.command.SurveyCreateCommand;
import com.sts.services.survey.command.SurveyUpdateCommand;
import com.sts.services.survey.entity.QuestionAnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionAnswerMapper {

    QuestionAnswerEntity toQuestionAnswerEntity(SurveyCreateCommand.QuestionAnswerCreateCommand questionAnswerCreateCommand);

    QuestionAnswerEntity toQuestionAnswerEntity(SurveyUpdateCommand.QuestionAnswerUpdateCommand questionAnswerUpdateCommand);

}
