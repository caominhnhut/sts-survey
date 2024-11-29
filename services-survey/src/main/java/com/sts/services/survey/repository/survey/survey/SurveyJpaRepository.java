package com.sts.services.survey.repository.survey.survey;

import com.sts.services.survey.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJpaRepository extends JpaRepository<SurveyEntity, Long> {
}
