package com.sts.services.survey.dto;

import com.sts.services.survey.entity.SurveyResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyHistoryQueryDto {

    private Long id;
    private String surveyId;
    private String username;
    private LocalDateTime submitDate;
    private Integer totalQuestion;
    private Integer passCorrectAnswerNumber;
    private Integer coverCorrectAnswerNumber;
    private BigDecimal passPercentage;
    private BigDecimal coverPercentage;
    private SurveyResult result;

}
