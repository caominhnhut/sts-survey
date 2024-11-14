package com.sts.services.survey.dto;

import com.sts.services.survey.entity.AnswerType;
import com.sts.services.survey.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionQueryDto {

    private Long id;
    private String name;
    private String description;
    private AnswerType answerType;
    private Status status;
    private List<QuestionAnswerQueryDto> answers;

}
