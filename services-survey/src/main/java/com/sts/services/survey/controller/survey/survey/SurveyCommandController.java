package com.sts.services.survey.controller.survey.survey;

import com.sts.services.survey.command.SurveyCreateCommand;
import com.sts.services.survey.command.SurveyUpdateCommand;
import com.sts.services.survey.dto.SurveyCreateDto;
import com.sts.services.survey.dto.SurveyUpdateDto;
import com.sts.services.survey.mapper.SurveyMapper;
import com.sts.services.survey.service.survey.survey.SurveyAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class SurveyCommandController {

    private final SurveyMapper surveyMapper;
    private final SurveyAppService surveyAppService;

    @PreAuthorize("hasAuthority('ROLE_fm') ")
    @PostMapping("/surveys")
    public ResponseEntity<Void> createSurvey(
            @Valid @RequestBody SurveyCreateDto surveyCreateDto) {
        new SurveyUpdateDto();
        SurveyCreateCommand createCommand = surveyMapper.toSurveyCreateCommand(surveyCreateDto);
        Long surveyId = surveyAppService.createSurvey(createCommand);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Expose-Headers", "X-ID");
        headers.set("X-ID", String.valueOf(surveyId));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_fm') ")
    @PatchMapping("/surveys/{surveyId}")
    public ResponseEntity<Void> updateSurvey(
            @PathVariable("surveyId") @Min(1) @Max(Integer.MAX_VALUE) Long surveyId,
            @Valid @RequestBody SurveyUpdateDto surveyUpdateDto) {
        SurveyUpdateCommand surveyUpdateCommand = surveyMapper.toSurveyUpdateCommand(surveyUpdateDto);
        surveyAppService.updateSurvey(surveyId, surveyUpdateCommand);
        return ResponseEntity.noContent().build();
    }

}
