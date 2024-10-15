package com.sts.services.survey.dto;

import com.sts.services.survey.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SurveyQueryDto {

    private Long id;
    private String name;
    private String description;
    private Long performTimeout;
    private Integer passCorrectAnswerNumber;
    private Status status;
    private List<QuestionQueryDto> questions;

}
