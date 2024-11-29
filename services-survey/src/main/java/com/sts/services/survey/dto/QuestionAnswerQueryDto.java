package com.sts.services.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerQueryDto {

    private Long id;
    private String name;
    private String description;
    private Boolean isCorrect;

}
