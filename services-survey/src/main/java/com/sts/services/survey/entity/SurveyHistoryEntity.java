package com.sts.services.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "survey_history")
@Data
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class SurveyHistoryEntity {

    @Id
    @Column(name = "survey_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "username")
    private String username;

    @Column(name = "submit_date")
    private LocalDateTime submitDate;

    @Column(name = "total_question")
    private Integer totalQuestion;

    @Column(name = "pass_correct_answer_number")
    private Integer passCorrectAnswerNumber;

    @Column(name = "cover_correct_answer_number")
    private Integer coverCorrectAnswerNumber;

    @Column(name = "pass_percentage")
    private BigDecimal passPercentage;

    @Column(name = "cover_percentage")
    private BigDecimal coverPercentage;

    @Column(name = "result")
    @Enumerated(EnumType.STRING)
    private SurveyResult result;
}
