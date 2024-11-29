package com.sts.services.survey.repository.survey.question;

import com.sts.services.survey.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {

    @Query(value = "SELECT q.*\n" +
            "FROM survey s\n" +
            "    JOIN survey_question sq ON s.survey_id = sq.survey_id\n" +
            "    JOIN question q ON sq.question_id = q.question_id\n" +
            "WHERE s.survey_id = ?1\n" +
            "  AND q.status = 'ACTIVE';", nativeQuery = true)
    List<QuestionEntity> findBySurveyId(Long surveyId);

}
