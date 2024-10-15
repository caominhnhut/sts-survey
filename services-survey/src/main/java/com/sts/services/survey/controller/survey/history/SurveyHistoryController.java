package com.sts.services.survey.controller.survey.history;

import com.sts.services.survey.dto.SurveyHistoryQueryDto;
import com.sts.services.survey.dto.common.ResponseDto;
import com.sts.services.survey.service.survey.history.SurveyHistoryQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SurveyHistoryController {

    @Autowired
    private SurveyHistoryQueryService surveyHistoryQueryService;

    @PreAuthorize("hasAuthority('ROLE_fm') or hasAuthority('ROLE_pm')")
    @GetMapping("/survey-histories")
    public ResponseEntity<ResponseDto<List<SurveyHistoryQueryDto>>> getSurveyHistories(@RequestParam String username) {
        List<SurveyHistoryQueryDto> surveyHistories = surveyHistoryQueryService.getSurveyHistories(username);
        return ResponseEntity.ok(ResponseDto.response(surveyHistories));
    }
}
