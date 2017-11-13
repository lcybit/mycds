package com.jefflee.service.assessment.questionnaire;

import java.util.List;

import com.jefflee.dto.QuestionnaireDto;
import com.jefflee.service.base.BaseService;

public interface QuestionnaireService extends BaseService<QuestionnaireDto, String> {

	public QuestionnaireDto create(QuestionnaireDto questionnaireDto) throws Exception;

	public QuestionnaireDto findById(String questionnaireId) throws Exception;

	public QuestionnaireDto findDetailById(String questionnaireId) throws Exception;

	public List<QuestionnaireDto> findList() throws Exception;

}