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

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public List<OptionDto> list(@PathVariable("id") String parentId) throws Exception {
		List<OptionDto> optionDtoList = optionService.findListByParentId(parentId);
		return optionDtoList;
	}

}