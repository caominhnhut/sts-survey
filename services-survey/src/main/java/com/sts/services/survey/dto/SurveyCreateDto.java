package com.sts.services.survey.dto;

import com.sts.services.survey.entity.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyCreateDto {

    @NotNull
    private String name;
    private String description;
    private Long performTimeout;
    @NotNull
    private Integer passCorrectAnswerNumber;
    @Valid
    private List<QuestionCreateDto> questions;

    @Data
    @AllArgsConstructor
    public static class QuestionCreateDto {

        @NotNull
        private String name;
        private String description;
        @NotNull
        private AnswerType answerType;
        @Valid
        private List<QuestionAnswerCreateDto> answers;

    }

    @Data
    @AllArgsConstructor
    public static class QuestionAnswerCreateDto {

        @NotNull
        private String name;
        private Boolean isCorrect;

    }

}
