package com.sts.services.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionAnswerQueryDto {

    private Long id;
    private String name;
    private String description;

}
