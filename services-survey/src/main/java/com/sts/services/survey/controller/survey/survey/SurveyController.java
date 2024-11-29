package com.sts.services.survey.controller.survey.survey;


import com.sts.services.survey.dto.SurveyQueryDto;
import com.sts.services.survey.dto.common.ResponseDto;
import com.sts.services.survey.service.survey.survey.SurveyQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Slf4j
@Validated
public class SurveyController {

    @Autowired
    private SurveyQueryService surveyQueryService;

    @PreAuthorize("hasAuthority('ROLE_fm') or hasAuthority('ROLE_pm')")
    @GetMapping("/surveys")
    public ResponseEntity<ResponseDto<List<SurveyQueryDto>>> getSurveys(
            @RequestParam(value = "activeOnly", required = false) boolean activeOnly
    ) {
        List<SurveyQueryDto> surveys = surveyQueryService.getSurveys(activeOnly);
        return ResponseEntity.ok(ResponseDto.response(surveys));
    }

    @PreAuthorize("hasAuthority('ROLE_fm') or hasAuthority('ROLE_pm')")
    @GetMapping("/surveys/{id}")
    public ResponseEntity<ResponseDto<SurveyQueryDto>> getSurveyDetails(@PathVariable("id") @Positive Long id) {
        SurveyQueryDto survey = surveyQueryService.getSurveyDetails(id);
        return ResponseEntity.ok(ResponseDto.response(survey));
    }

    @PreAuthorize("hasAuthority('ROLE_fm')")
    @GetMapping("/surveys/{id}/config")
    public ResponseEntity<ResponseDto<SurveyQueryDto>> getSurveyDetailsConfig(@PathVariable("id") @Positive Long id) {
        SurveyQueryDto surveys = surveyQueryService.getSurveyDetailsConfig(id);
        return ResponseEntity.ok(ResponseDto.response(surveys));
    }

}
