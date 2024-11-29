package com.sts.services.survey.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUserSubmitRequestDto {

    @NotNull
    @Valid
    private List<QuestionAnswerDto> questionAnswers;

    @Data
    @AllArgsConstructor
    public static class QuestionAnswerDto {

        @NotNull
        private Long questionId;
        private List<Long> answerIds;
        private String answerText;
    }

}
