package com.sts.services.survey.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SurveyUserSubmitRequestDto {

    @NotNull
    @Valid
    private List<QuestionAnswerDto> questionAnswers;

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerDto {

        @NotNull
        private Long questionId;
        private List<Long> answerIds;
        private String answerText;
    }

}
