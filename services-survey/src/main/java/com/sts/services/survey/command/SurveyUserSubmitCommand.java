package com.sts.services.survey.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUserSubmitCommand {

    private List<QuestionAnswerSubmitCommand> questionAnswers;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerSubmitCommand {

        private Long questionId;
        private List<Long> answerIds;
        private String answerText;

    }

}
