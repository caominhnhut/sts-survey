package com.sts.services.survey.controller.survey.user;

import com.sts.services.survey.dto.SurveyUserResultResponseDto;
import com.sts.services.survey.dto.SurveyUserSubmitRequestDto;
import com.sts.services.survey.dto.common.ResponseDto;
import com.sts.services.survey.mapper.SurveyUserMapper;
import com.sts.services.survey.model.SurveyUserResult;
import com.sts.services.survey.model.SurveyUserSubmit;
import com.sts.services.survey.service.survey.user.SurveyUserAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Slf4j
@Validated
public class SurveyUserCommandController {

    @Autowired
    private SurveyUserMapper surveyUserMapper;

    @Autowired
    private SurveyUserAppService surveyUserAppService;

    @PreAuthorize("hasAuthority('ROLE_fm') or hasAuthority('ROLE_pm')")
    @PostMapping("/users/surveys/{surveyId}")
    public ResponseEntity<ResponseDto<SurveyUserResultResponseDto>> submitSurvey(@PathVariable @Positive Long surveyId,
                                                                                 @Valid @RequestBody SurveyUserSubmitRequestDto surveyUserSubmitRequestDto) {
        SurveyUserSubmit surveyUserSubmit = surveyUserMapper.toSurveyUserSubmit(surveyUserSubmitRequestDto);
        SurveyUserResult surveyUserResult = surveyUserAppService.submit(surveyId, surveyUserSubmit);
        return ResponseEntity.ok(ResponseDto.response(surveyUserMapper.fromSurveyUserResult(surveyUserResult)));
    }

}
