package com.sts.services.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SurveyEntity {

    @Id
    @Column(name = "survey_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "perform_timeout")
    private Long performTimeout;

    @Column(name = "pass_correct_answer_number")
    private Integer passCorrectAnswerNumber;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
