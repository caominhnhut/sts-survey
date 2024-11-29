package com.sts.services.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "survey_question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SurveyQuestionEntity {

    @Id
    @Column(name = "survey_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "question_id")
    private Long questionId;


}
