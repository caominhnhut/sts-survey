package com.sts.services.survey.service.survey.user;

import com.sts.services.survey.entity.AnswerType;
import com.sts.services.survey.entity.QuestionAnswerEntity;
import com.sts.services.survey.entity.QuestionEntity;
import com.sts.services.survey.entity.Status;
import com.sts.services.survey.entity.SurveyEntity;
import com.sts.services.survey.entity.SurveyHistoryEntity;
import com.sts.services.survey.entity.SurveyResult;
import com.sts.services.survey.exception.ValidationException;
import com.sts.services.survey.model.SurveyUserResult;
import com.sts.services.survey.model.SurveyUserSubmit;
import com.sts.services.survey.service.survey.history.SurveyHistoryAdapter;
import com.sts.services.survey.service.survey.question.QuestionAdapter;
import com.sts.services.survey.service.survey.questionanswer.QuestionAnswerAdapter;
import com.sts.services.survey.service.survey.survey.SurveyAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyUserAppService {

    @Autowired
    private SurveyAdapter surveyAdapter;
    @Autowired
    private QuestionAdapter questionAdapter;
    @Autowired
    private QuestionAnswerAdapter questionAnswerAdapter;
    @Autowired
    private SurveyHistoryAdapter surveyHistoryAdapter;

    @Transactional
    public SurveyUserResult submit(Long surveyId, SurveyUserSubmit surveyUserSubmit) {
        // -- Get username from authentication
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        SurveyEntity survey = surveyAdapter.findById(surveyId).orElseThrow(() -> new ValidationException("surveyId", "Survey not found"));
        if (!Status.ACTIVE.equals(survey.getStatus()))
            throw new ValidationException("surveyId", "Survey is not active");

        List<QuestionEntity> questions = questionAdapter.findBySurveyId(surveyId);
        // -- Only get correct answers, no need to get all, better for performance.
        List<QuestionAnswerEntity> correctQuestionAnswers = questionAnswerAdapter.getCorrectQuestionAnswers(surveyId);

        // -- Calculation
        long correctAnswerSurveyUser = validateAndGetCorrectAnswerSurveyUser(surveyUserSubmit, correctQuestionAnswers);
        SurveyUserResult surveyUserResult = buildSurveyUserResult(questions, survey.getPassCorrectAnswerNumber(), correctAnswerSurveyUser);
        createSurveyHistory(surveyId, questions.size(), username, surveyUserResult);

        return surveyUserResult;
    }


    private long validateAndGetCorrectAnswerSurveyUser(SurveyUserSubmit surveyUserSubmit, List<QuestionAnswerEntity> correctQuestionAnswers) {
        // Map<questionId, correctAnswerIds> for look up
        Map<Long, List<Long>> correctQuestionAnswerMap = new HashMap<Long, List<Long>>();
        correctQuestionAnswers.forEach(questionAnswer ->
                correctQuestionAnswerMap.compute(questionAnswer.getQuestionId(), (questionId, answerIds) -> {
                    if (answerIds == null) answerIds = new ArrayList<>(List.of(questionAnswer.getId()));
                    else answerIds.add(questionAnswer.getId());
                    return answerIds;
                })
        );

        // Currently checking for selection question only, in reality it could be no such thing as TEXT question for survey
        return surveyUserSubmit.getQuestionAnswers().stream()
                .filter(userQuestionAnswer -> {
                    List<Long> correctAnswerIds = correctQuestionAnswerMap.get(userQuestionAnswer.getQuestionId());
                    // Ignore warning, no distinction for ids in checking correct answer.
                    return correctAnswerIds != null && userQuestionAnswer.getAnswerIds() != null
                            && userQuestionAnswer.getAnswerIds().size() == correctAnswerIds.size()
                            && userQuestionAnswer.getAnswerIds().containsAll(correctAnswerIds);
                })
                .count();
    }


    private SurveyUserResult buildSurveyUserResult(List<QuestionEntity> questions, Integer passCorrectAnswerNumber, long correctAnswerSurveyUser) {
        int totalQuestions = questions.size();

        // In case question get deactivated or delete
        if (passCorrectAnswerNumber > totalQuestions) passCorrectAnswerNumber = totalQuestions;

        long selectionQuestions = questions.stream()
                .filter(questionEntity -> List.of(AnswerType.SINGLE, AnswerType.MULTI).contains(questionEntity.getAnswerType()))
                .count();

        // Auto correct for non selection question
        long nonSelectionQuestions = totalQuestions - selectionQuestions;

        Integer coverCorrectAnswerNumber = Math.toIntExact(correctAnswerSurveyUser + nonSelectionQuestions);
        BigDecimal coverPercentage = BigDecimal.valueOf(((double) coverCorrectAnswerNumber / totalQuestions) * 100).setScale(2, RoundingMode.HALF_UP);
        BigDecimal passPercentage = BigDecimal.valueOf(((double) passCorrectAnswerNumber / totalQuestions) * 100).setScale(2, RoundingMode.HALF_UP);
        SurveyResult surveyResult = coverCorrectAnswerNumber >= passCorrectAnswerNumber ? SurveyResult.PASS : SurveyResult.FAIL;

        return new SurveyUserResult(totalQuestions, passCorrectAnswerNumber, coverCorrectAnswerNumber, passPercentage, coverPercentage, surveyResult);
    }

    private void createSurveyHistory(Long surveyId, int totalQuestion, String username, SurveyUserResult surveyUserResult) {
        SurveyHistoryEntity surveyHistoryEntity = new SurveyHistoryEntity();
        surveyHistoryEntity.setSurveyId(surveyId);
        surveyHistoryEntity.setUsername(username);
        surveyHistoryEntity.setSubmitDate(LocalDateTime.now());
        surveyHistoryEntity.setTotalQuestion(totalQuestion);
        surveyHistoryEntity.setPassCorrectAnswerNumber(surveyUserResult.getPassCorrectAnswerNumber());
        surveyHistoryEntity.setCoverCorrectAnswerNumber(surveyUserResult.getCoverCorrectAnswerNumber());
        surveyHistoryEntity.setPassPercentage(surveyUserResult.getPassPercentage());
        surveyHistoryEntity.setCoverPercentage(surveyUserResult.getCoverPercentage());
        surveyHistoryEntity.setResult(surveyUserResult.getResult());
        surveyHistoryAdapter.create(surveyHistoryEntity);
    }

}
