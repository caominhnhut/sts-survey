package com.sts.services.survey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SurveyUserSubmit {

    private List<QuestionAnswer> questionAnswers;

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswer {

        private Long questionId;
        private List<Long> answerIds;
        private String answerText;

    }

}
