package com.sts.services.survey.repository.survey.history;

import com.sts.services.survey.entity.SurveyHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyHistoryJpaRepository extends JpaRepository<SurveyHistoryEntity, Long> {

}
