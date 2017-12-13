package com.jefflee.controller.assessment.question;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.QuestionDto;
import com.jefflee.service.assessment.question.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Resource(name = "questionService")
	private QuestionService questionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public QuestionDto create(@RequestBody QuestionDto questionDto) throws Exception {
		questionDto = questionService.create(questionDto);
		return questionDto;
	}

	@RequestMapping(value = "/find/{questionId}", method = RequestMethod.GET)
	public QuestionDto find(@PathVariable("questionId") String questionId) throws Exception {
		QuestionDto questionDto = questionService.findById(questionId);
		return questionDto;
	}

	@RequestMapping(value = "/list/{questionnaireId}", method = RequestMethod.GET)
	public List<QuestionDto> list(@PathVariable("questionnaireId") String questionnaireId) throws Exception {
		List<QuestionDto> questionDtoList = questionService.findListByParentId(questionnaireId);
		return questionDtoList;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public QuestionDto modify(@RequestBody QuestionDto questionDto) throws Exception {
		questionDto = questionService.modify(questionDto);
		return questionDto;
	}

}