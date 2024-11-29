package com.sts.services.survey.dto;

import com.sts.services.survey.entity.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUpdateDto {

    private String name;
    private Optional<String> description;
    private Long performTimeout;
    private Integer passCorrectAnswerNumber;
    private List<QuestionUpdateDto> questions;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionUpdateDto {

        private Long id;
        private String name;
        private Optional<String> description;
        private AnswerType answerType;
        private List<QuestionAnswerUpdateDto> answers;
        private Boolean isDeleted = Boolean.FALSE;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerUpdateDto {

        private Long id;
        private String name;
        private Boolean isCorrect;
        private Boolean isDeleted = Boolean.FALSE;

    }

}
