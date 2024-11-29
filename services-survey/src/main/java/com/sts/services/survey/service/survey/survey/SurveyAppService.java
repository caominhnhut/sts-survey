package com.sts.services.survey.service.survey.survey;

import com.sts.services.survey.command.SurveyCreateCommand;
import com.sts.services.survey.command.SurveyUpdateCommand;
import com.sts.services.survey.entity.QuestionAnswerEntity;
import com.sts.services.survey.entity.QuestionEntity;
import com.sts.services.survey.entity.SurveyEntity;
import com.sts.services.survey.entity.SurveyQuestionEntity;
import com.sts.services.survey.exception.ValidationException;
import com.sts.services.survey.factory.FieldUtils;
import com.sts.services.survey.mapper.QuestionAnswerMapper;
import com.sts.services.survey.mapper.QuestionMapper;
import com.sts.services.survey.mapper.SurveyMapper;
import com.sts.services.survey.service.survey.question.adapter.QuestionAdapter;
import com.sts.services.survey.service.survey.question.adapter.SurveyQuestionAdapter;
import com.sts.services.survey.service.survey.questionanswer.adapter.QuestionAnswerAdapter;
import com.sts.services.survey.service.survey.survey.adapter.SurveyAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyAppService {

    private final SurveyMapper surveyMapper;
    private final QuestionMapper questionMapper;
    private final QuestionAnswerMapper questionAnswerMapper;

    private final SurveyAdapter surveyAdapter;
    private final QuestionAdapter questionAdapter;
    private final QuestionAnswerAdapter questionAnswerAdapter;
    private final SurveyQuestionAdapter surveyQuestionAdapter;

    @Transactional
    public Long createSurvey(SurveyCreateCommand surveyCreateCommand) {
        SurveyEntity createdSurvey = createSurveyEntity(surveyCreateCommand);
        createQuestionsAndLinkToSurvey(createdSurvey.getId(), surveyCreateCommand.getQuestions());
        return createdSurvey.getId();
    }

    @Transactional
    public void updateSurvey(Long surveyId, SurveyUpdateCommand surveyUpdateCommand) {
        SurveyEntity survey = surveyAdapter.findById(surveyId).orElseThrow(() -> new ValidationException("surveyId", "Survey not found"));
        // Detect question actions
        List<SurveyUpdateCommand.QuestionUpdateCommand> questionsToBeDeleted = new ArrayList<>();
        List<SurveyUpdateCommand.QuestionUpdateCommand> questionsToBeUpdated = new ArrayList<>();
        List<SurveyUpdateCommand.QuestionUpdateCommand> questionsToBeCreated = new ArrayList<>();
        surveyUpdateCommand.getQuestions().forEach(questionCmd -> {
            if (Objects.isNull(questionCmd.getId())) questionsToBeCreated.add(questionCmd);
            else if (questionCmd.getIsDeleted().equals(Boolean.TRUE)) questionsToBeDeleted.add(questionCmd);
            else questionsToBeUpdated.add(questionCmd);
        });

        deleteQuestions(surveyId, questionsToBeDeleted);
        updateQuestion(questionsToBeUpdated);
        createQuestions(surveyId, questionsToBeCreated);
        updateSurvey(survey, surveyUpdateCommand);
    }

    private SurveyEntity createSurveyEntity(SurveyCreateCommand surveyCreateCommand) {
        SurveyEntity surveyEntity = surveyMapper.toSurveyEntity(surveyCreateCommand);
        return surveyAdapter.save(surveyEntity);
    }

    private void createQuestionsAndLinkToSurvey(Long surveyId, List<SurveyCreateCommand.QuestionCreateCommand> questionCreateCommands) {
        List<QuestionEntity> createdQuestions = createQuestionsAndAnswers(questionCreateCommands);
        linkSurveyQuestions(surveyId, createdQuestions);
    }

    private List<QuestionEntity> createQuestionsAndAnswers(List<SurveyCreateCommand.QuestionCreateCommand> questionCreateCommands) {
        // TODO: DB Structure from the beginning allows Question could be long to many different Surveys
        //  But at the moment we don't have time for that, it could be another way to add question to survey later
        //  Later: Questions should be validated duplicate name.
        Map<String, List<SurveyCreateCommand.QuestionAnswerCreateCommand>> answerLookUp = new HashMap<>();
        List<QuestionEntity> questionEntities = new ArrayList<>();
        questionCreateCommands.forEach(questionCreateCommand -> {
            QuestionEntity questionEntity = questionMapper.toQuestionEntity(questionCreateCommand);
            questionEntities.add(questionEntity);
            answerLookUp.put(questionCreateCommand.getName(), questionCreateCommand.getAnswers());
        });
        // Create questions.
        List<QuestionEntity> createdQuestions = questionAdapter.saveAll(questionEntities);

        // Create list of answers for each created question.
        createdQuestions.forEach(createdQuestion -> {
            List<SurveyCreateCommand.QuestionAnswerCreateCommand> questionAnswerCreateCommands = answerLookUp.get(createdQuestion.getName());
            if (questionAnswerCreateCommands != null) {
                List<QuestionAnswerEntity> questionAnswerEntities = new ArrayList<>();
                questionAnswerCreateCommands.forEach(questionAnswerCreateCommand -> {
                    QuestionAnswerEntity questionAnswerEntity = questionAnswerMapper.toQuestionAnswerEntity(questionAnswerCreateCommand);
                    questionAnswerEntity.setQuestionId(createdQuestion.getId());
                    questionAnswerEntities.add(questionAnswerEntity);
                });
                questionAnswerAdapter.saveAll(questionAnswerEntities);
            }
        });

        return createdQuestions;
    }

    private void deleteQuestions(Long surveyId, List<SurveyUpdateCommand.QuestionUpdateCommand> questionsToBeDeleted) {
        unlinkSurveysQuestions(surveyId, questionsToBeDeleted.stream().map(SurveyUpdateCommand.QuestionUpdateCommand::getId).toList());
    }

    private void updateQuestion(List<SurveyUpdateCommand.QuestionUpdateCommand> questionUpdateCommands) {
        List<QuestionEntity> existingQuestions = questionAdapter.findAll(questionUpdateCommands.stream().map(SurveyUpdateCommand.QuestionUpdateCommand::getId).toList());
        Map<Long, QuestionEntity> lookup = existingQuestions.stream().collect(Collectors.toMap(QuestionEntity::getId, q -> q));

        List<Long> questionAnswerIdsToBeDeleted = new ArrayList<>();
        List<SurveyUpdateCommand.QuestionAnswerUpdateCommand> questionAnswersToBeUpdated = new ArrayList<>();
        List<QuestionAnswerEntity> questionAnswersToBeCreated = new ArrayList<>();

        questionUpdateCommands.forEach(questionUpdateCommand -> {
            // Detect answers actions of all update questions
            detectAnswerActions(questionUpdateCommand, questionAnswersToBeCreated, questionAnswerIdsToBeDeleted, questionAnswersToBeUpdated);
            updateQuestion(questionUpdateCommand, lookup);
        });

        deleteAnswers(questionAnswerIdsToBeDeleted);
        updateAnswers(questionAnswersToBeUpdated);
        createAnswers(questionAnswersToBeCreated);

        questionAdapter.saveAll(existingQuestions);
    }


    private void updateQuestion(SurveyUpdateCommand.QuestionUpdateCommand questionCmd, Map<Long, QuestionEntity> lookup) {
        QuestionEntity existingQuestion = lookup.get(questionCmd.getId());
        if (!Objects.isNull(existingQuestion)) {
            FieldUtils.ifNotNull(questionCmd.getName(), existingQuestion::setName);
            FieldUtils.ifOptionalDefined(questionCmd.getDescription(), existingQuestion::setDescription);
            FieldUtils.ifNotNull(questionCmd.getAnswerType(), existingQuestion::setAnswerType);
        }
    }

    private void detectAnswerActions(SurveyUpdateCommand.QuestionUpdateCommand questionUpdateCommand, List<QuestionAnswerEntity> questionAnswersToBeCreated, List<Long> questionAnswerIdsToBeDeleted, List<SurveyUpdateCommand.QuestionAnswerUpdateCommand> questionAnswersToBeUpdated) {
        questionUpdateCommand.getAnswers().forEach(answerCmd -> {
            if (Objects.isNull(answerCmd.getId())) {
                QuestionAnswerEntity questionAnswer = questionAnswerMapper.toQuestionAnswerEntity(answerCmd);
                questionAnswer.setQuestionId(questionUpdateCommand.getId());
                questionAnswersToBeCreated.add(questionAnswer);
            } else if (answerCmd.getIsDeleted().equals(Boolean.TRUE)) {
                // Add id directly, no need to loop through all items again to get id
                questionAnswerIdsToBeDeleted.add(answerCmd.getId());
            } else {
                questionAnswersToBeUpdated.add(answerCmd);
            }
        });
    }

    private void deleteAnswers(List<Long> questionAnswerIdsToBeDeleted) {
        questionAnswerAdapter.deleteAll(questionAnswerIdsToBeDeleted);
    }

    private void updateAnswers(List<SurveyUpdateCommand.QuestionAnswerUpdateCommand> questionAnswerUpdateCommands) {
        List<QuestionAnswerEntity> existingAnswers = questionAnswerAdapter.findAll(questionAnswerUpdateCommands.stream().map(SurveyUpdateCommand.QuestionAnswerUpdateCommand::getId).toList());
        Map<Long, QuestionAnswerEntity> lookup = existingAnswers.stream().collect(Collectors.toMap(QuestionAnswerEntity::getId, a -> a));
        questionAnswerUpdateCommands.forEach(answerCmd -> {
            QuestionAnswerEntity existingAnswer = lookup.get(answerCmd.getId());
            if (!Objects.isNull(existingAnswer)) {
                FieldUtils.ifNotNull(answerCmd.getName(), existingAnswer::setName);
                FieldUtils.ifNotNull(answerCmd.getIsCorrect(), existingAnswer::setIsCorrect);
            }
        });
        questionAnswerAdapter.saveAll(existingAnswers);
    }

    private void createAnswers(List<QuestionAnswerEntity> questionAnswerEntities) {
        questionAnswerAdapter.saveAll(questionAnswerEntities);
    }

    private void createQuestions(Long surveyId, List<SurveyUpdateCommand.QuestionUpdateCommand> questionsToBeCreated) {
        createQuestionsAndLinkToSurvey(surveyId, mapToQuestionCreateCommands(questionsToBeCreated));
    }

    private void updateSurvey(SurveyEntity existingSurvey, SurveyUpdateCommand surveyCmd) {
        FieldUtils.ifNotNull(surveyCmd.getName(), existingSurvey::setName);
        FieldUtils.ifOptionalDefined(surveyCmd.getDescription(), existingSurvey::setDescription);
        FieldUtils.ifNotNull(surveyCmd.getPerformTimeout(), existingSurvey::setPerformTimeout);
        FieldUtils.ifNotNull(surveyCmd.getPassCorrectAnswerNumber(), existingSurvey::setPassCorrectAnswerNumber);
    }

    private void linkSurveyQuestions(Long surveyId, List<QuestionEntity> createdQuestions) {
        List<SurveyQuestionEntity> surveyQuestionEntities = createdQuestions.stream().map(createdQuestion -> map(surveyId, createdQuestion.getId())).toList();
        surveyQuestionAdapter.saveAll(surveyQuestionEntities);
    }

    private void unlinkSurveysQuestions(Long surveyId, List<Long> questionIds) {
        surveyQuestionAdapter.deleteAllBySurveyIdAndQuestionIds(surveyId, questionIds);
    }

    private SurveyQuestionEntity map(Long surveyId, Long questionId) {
        SurveyQuestionEntity surveyQuestionEntity = new SurveyQuestionEntity();
        surveyQuestionEntity.setSurveyId(surveyId);
        surveyQuestionEntity.setQuestionId(questionId);
        return surveyQuestionEntity;
    }

    private List<SurveyCreateCommand.QuestionCreateCommand> mapToQuestionCreateCommands(List<SurveyUpdateCommand.QuestionUpdateCommand> updateQuestions) {
        return updateQuestions.stream()
                .map(item -> new SurveyCreateCommand.QuestionCreateCommand(item.getName(), item.getDescription().orElse(null), item.getAnswerType(), mapToAnswerCreateCommands(item.getAnswers())))
                .toList();
    }

    private List<SurveyCreateCommand.QuestionAnswerCreateCommand> mapToAnswerCreateCommands(List<SurveyUpdateCommand.QuestionAnswerUpdateCommand> updateAnswers) {
        return updateAnswers.stream()
                .map(updateAnswer -> new SurveyCreateCommand.QuestionAnswerCreateCommand(updateAnswer.getName(), updateAnswer.getIsCorrect()))
                .toList();
    }


}
