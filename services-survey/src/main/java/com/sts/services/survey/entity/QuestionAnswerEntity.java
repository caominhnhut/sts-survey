package com.sts.services.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "question_answer")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
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
