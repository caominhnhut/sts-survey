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
@Table(name = "question_answer")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuestionAnswerEntity {

    @Id
    @Column(name = "question_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
