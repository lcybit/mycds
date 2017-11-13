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

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public List<QuestionDto> list(@PathVariable("id") String parentId) throws Exception {
		List<QuestionDto> questionDtoList = questionService.findListByParentId(parentId);
		return questionDtoList;
	}

}