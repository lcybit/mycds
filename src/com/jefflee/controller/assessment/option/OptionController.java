package com.jefflee.controller.assessment.option;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jefflee.dto.OptionDto;
import com.jefflee.service.assessment.option.OptionService;

@RestController
@RequestMapping("/option")
public class OptionController {

	@Resource(name = "optionService")
	private OptionService optionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public OptionDto create(@RequestBody OptionDto optionDto) throws Exception {
		optionDto = optionService.create(optionDto);
		return optionDto;
	}

	@RequestMapping(value = "/find/{optionId}", method = RequestMethod.GET)
	public OptionDto find(@PathVariable("optionId") String optionId) throws Exception {
		OptionDto optionDto = optionService.findById(optionId);
		return optionDto;
	}

	@RequestMapping(value = "/list/{questionId}", method = RequestMethod.GET)
	public List<OptionDto> list(@PathVariable("questionId") String questionId) throws Exception {
		List<OptionDto> optionDtoList = optionService.findListByParentId(questionId);
		return optionDtoList;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public OptionDto modify(@RequestBody OptionDto optionDto) throws Exception {
		optionDto = optionService.modify(optionDto);
		return optionDto;
	}

}