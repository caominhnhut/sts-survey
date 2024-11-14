package com.sts.services.survey.command;

import com.sts.services.survey.entity.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUpdateCommand {

    private String name;
    private Optional<String> description;
    private Long performTimeout;
    private Integer passCorrectAnswerNumber;
    private List<QuestionUpdateCommand> questions;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionUpdateCommand {

        private Long id;
        private String name;
        private Optional<String> description;
        private AnswerType answerType;
        private List<QuestionAnswerUpdateCommand> answers;
        private Boolean isDeleted = Boolean.FALSE;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerUpdateCommand {

        private Long id;
        private String name;
        private Boolean isCorrect;
        private Boolean isDeleted = Boolean.FALSE;

    }

}
