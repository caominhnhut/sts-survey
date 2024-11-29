package com.sts.services.survey.model;

import com.sts.services.survey.entity.SurveyResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SurveyUserResult {

    private Integer totalQuestion;
    private Integer passCorrectAnswerNumber;
    private Integer coverCorrectAnswerNumber;
    private BigDecimal passPercentage;
    private BigDecimal coverPercentage;
    private SurveyResult result;

}
