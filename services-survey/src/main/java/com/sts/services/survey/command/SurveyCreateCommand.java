package com.sts.services.survey.command;

import com.sts.services.survey.entity.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyCreateCommand {

    private String name;
    private String description;
    private Long performTimeout;
    private Integer passCorrectAnswerNumber;
    private List<QuestionCreateCommand> questions;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionCreateCommand {

        private String name;
        private String description;
        private AnswerType answerType;
        private List<QuestionAnswerCreateCommand> answers;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerCreateCommand {

        private String name;
        private Boolean isCorrect;

    }

}
