package com.sts.services.survey.command;

import com.sts.services.survey.entity.SurveyResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyUserResultCommand {

    private Integer totalQuestion;
    private Integer passCorrectAnswerNumber;
    private Integer coverCorrectAnswerNumber;
    private BigDecimal passPercentage;
    private BigDecimal coverPercentage;
    private SurveyResult result;

}
