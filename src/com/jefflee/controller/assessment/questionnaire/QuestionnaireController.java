package com.jefflee.controller.assessment.questionnaire;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.QuestionnaireDto;
import com.jefflee.service.assessment.questionnaire.QuestionnaireService;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

	@Resource(name = "questionnaireService")
	private QuestionnaireService questionnaireService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public QuestionnaireDto create(@RequestBody QuestionnaireDto questionnaireDto) throws Exception {
		questionnaireDto = questionnaireService.create(questionnaireDto);
		return questionnaireDto;
	}

	@RequestMapping(value = "/detail/{questionnaireId}", method = RequestMethod.GET)
	public QuestionnaireDto detail(@PathVariable("questionnaireId") String questionnaireId) throws Exception {
		QuestionnaireDto questionnaireDto = questionnaireService.findDetailById(questionnaireId);
		return questionnaireDto;
	}

	@RequestMapping(value = "/find/{questionnaireId}", method = RequestMethod.GET)
	public QuestionnaireDto find(@PathVariable("questionnaireId") String questionnaireId) throws Exception {
		QuestionnaireDto questionnaireDto = questionnaireService.findById(questionnaireId);
		return questionnaireDto;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<QuestionnaireDto> list() throws Exception {
		List<QuestionnaireDto> questionnaireDtoList = questionnaireService.findList();
		return questionnaireDtoList;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public QuestionnaireDto modify(@RequestBody QuestionnaireDto questionnaireDto) throws Exception {
		questionnaireDto = questionnaireService.modify(questionnaireDto);
		return questionnaireDto;
	}

}