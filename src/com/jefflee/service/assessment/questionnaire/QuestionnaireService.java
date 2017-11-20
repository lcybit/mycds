package com.jefflee.service.assessment.questionnaire;

import java.util.List;

import com.jefflee.dto.QuestionnaireDto;
import com.jefflee.service.base.BaseService;

public interface QuestionnaireService extends BaseService<QuestionnaireDto, String> {

	QuestionnaireDto create(QuestionnaireDto questionnaireDto) throws Exception;

	QuestionnaireDto findById(String questionnaireId) throws Exception;

	QuestionnaireDto findDetailById(String questionnaireId) throws Exception;

	List<QuestionnaireDto> findList() throws Exception;

	QuestionnaireDto modify(QuestionnaireDto questionnaireDto) throws Exception;

}