package com.sts.services.survey.repository.survey.question;

import com.sts.services.survey.entity.SurveyQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyQuestionJpaRepository extends JpaRepository<SurveyQuestionEntity, Long> {

    public void deleteAllBySurveyIdAndQuestionIdIn(Long surveyId, List<Long> questionIds);

}
