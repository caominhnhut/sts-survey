package com.sts.services.survey.repository.survey.questionanswer;

import com.sts.services.survey.entity.QuestionAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionAnswerJpaRepository extends JpaRepository<QuestionAnswerEntity, Long> {

    @Query(value = "SELECT qa.*\n" +
            "FROM survey s\n" +
            "    JOIN survey_question sq ON s.survey_id = sq.survey_id\n" +
            "    JOIN question q ON sq.question_id = q.question_id\n" +
            "    JOIN question_answer qa ON q.question_id = qa.question_id\n" +
            "WHERE s.survey_id = ?1\n" +
            "  AND qa.is_correct = TRUE\n" +
            "  AND q.answer_type != 'TEXT'\n" +
            "  AND q.status = 'ACTIVE'\n" +
            "  AND qa.status = 'ACTIVE';", nativeQuery = true)
    List<QuestionAnswerEntity> getCorrectQuestionAnswers(Long surveyId);

}
